package handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import member.dao.StoreRequest;
import member.service.DuplicateStoreNoExcetpion;
import mvc.command.CommandHandler;
import service.StoreService;
import vo.JsonVO;

public class ApiHandler implements CommandHandler {
	private static final String FORM_VIEW = "WEB-INF/view/api/apiSync.jsp";

	private StoreService storeService = new StoreService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		String result = "";
		JSONObject jsonObj = null;
		JSONObject jsonObj2 = null;

		List<JsonVO> arrayList = new ArrayList<JsonVO>();
		
		String list_total_count = "";		//전체 api row 갯수
		
		// TODO API 전체 갯수 확인
		
		try {
			BufferedReader br = null;
			String chkTotalCountResult = "";
			
			String urlstr = "http://openapi.seoul.go.kr:8088/56504d68436c6565353067596b7578/json/LOCALDATA_072405/1/1/";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

			String line;
			while ((line = br.readLine()) != null) {
				chkTotalCountResult = chkTotalCountResult + line;
			}
			
			//list_total_count
			JSONParser parser = new JSONParser();
			jsonObj = (JSONObject) parser.parse(chkTotalCountResult);
			jsonObj2 = (JSONObject) jsonObj.get("LOCALDATA_072405");
			list_total_count = jsonObj2.get("list_total_count").toString();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int endNo = Integer.parseInt(list_total_count)/500;
		int lastNo = Integer.parseInt(list_total_count)%500;
		int pageNo = 500;
		
		for(int j=0; j<endNo; j++ ) {
			String urlstr = "http://openapi.seoul.go.kr:8088/56504d68436c6565353067596b7578/json/LOCALDATA_072405/";
			System.out.println("j="+j);
			if(j==endNo-1) {
				urlstr = urlstr+((j*pageNo)+1)+"/"+((j*pageNo)+lastNo)+"/";
			}else {
				urlstr = urlstr+((j*pageNo)+1)+"/"+((j*pageNo)+pageNo)+"/";
			}
			
			// TODO API 통신
			
			BufferedReader br = null;
			try {
//				urlstr = "http://openapi.seoul.go.kr:8088/56504d68436c6565353067596b7578/json/LOCALDATA_072405/1/500/";
				URL url = new URL(urlstr);
				HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
				br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

				String line;
				while ((line = br.readLine()) != null) {
					result = result + line;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// TODO 데이터 변환

			try {
				JSONParser parser = new JSONParser();
				jsonObj = (JSONObject) parser.parse(result);
				jsonObj2 = (JSONObject) jsonObj.get("LOCALDATA_072405");

				JSONArray jsonArray = (JSONArray) ((JSONObject) jsonObj2).get("row");

				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject jsonObj3 = new JSONObject();
					jsonObj3 = (JSONObject) jsonArray.get(i);

					JsonVO vo = new JsonVO();
					
//					vo.setDTLSTATENM(jsonObj3.get("DTLSTATENM").toString());
//					vo.setUPTAENM(jsonObj3.get("UPTAENM").toString());

					if (jsonObj3.get("BPLCNM").toString() != null && !jsonObj3.get("BPLCNM").toString().trim().equals("")) {
						if (jsonObj3.get("RDNWHLADDR").toString() != null
								&& !jsonObj3.get("RDNWHLADDR").toString().trim().equals("")) {
							
							if (jsonObj3.get("DTLSTATENM").toString().equals("영업")) {
								if (jsonObj3.get("UPTAENM").toString().equals("과자점") || jsonObj3.get("UPTAENM").toString().equals("떡카페")
										|| jsonObj3.get("UPTAENM").toString().equals("아이스크림") || jsonObj3.get("UPTAENM").toString().equals("전통찻집")
										|| jsonObj3.get("UPTAENM").toString().equals("커피숍")) {
									vo.setBPLCNM(jsonObj3.get("BPLCNM").toString());
									vo.setRDNWHLADDR(jsonObj3.get("RDNWHLADDR").toString());
									vo.setSITETEL(jsonObj3.get("SITETEL").toString());
									vo.setMGTNO(jsonObj3.get("MGTNO").toString());
									arrayList.add(vo);
								}
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// TODO 저장

			for (int i = 0; i < arrayList.size(); i++) {
				JsonVO vo = new JsonVO();
				StoreRequest storeReq = new StoreRequest();
				System.out.println("i="+i);
				vo = arrayList.get(i);
				
				storeReq.setStoreName(vo.getBPLCNM());
				
				if(vo.getRDNWHLADDR() == null || "".equals(vo.getRDNWHLADDR())) {
					storeReq.setAddress("n/a");
				}else {
					storeReq.setAddress(vo.getRDNWHLADDR());
				}
				
				if(vo.getSITETEL() == null || "".equals(vo.getSITETEL())) {
					storeReq.setCallNumber(null);
				}else {
					String callNum = vo.getSITETEL().trim();
					callNum = callNum.replaceAll(" ", "");
					storeReq.setCallNumber(callNum);
				}
				
				if(vo.getMGTNO() == null || "".equals(vo.getMGTNO())) {
					storeReq.setManageNo("n/a");
				}else {
					storeReq.setManageNo(vo.getMGTNO());
				}
				
//				storeReq.setManageNo(vo.getMGTNO());
//				
//				if(storeReq == null || "".equals(storeReq.getManageNo())) {
//					storeReq.setManageNo("n/a");
//				}
				storeService.store(storeReq);
			}
		}
		
		try {
			return "WEB-INF/view/api/apiSuccess.jsp";
		} catch (DuplicateStoreNoExcetpion e) {
			e.printStackTrace();
			errors.put("duplicateStoreNo", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
