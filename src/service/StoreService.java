package service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.STOREINFODao;
import member.dao.StoreRequest;
import member.model.STOREINFO;
import member.service.DuplicateStoreNoExcetpion;

public class StoreService {
	
	private STOREINFODao storeDao = new STOREINFODao();
	
	public void store(StoreRequest storeReq) {
		Connection conn  = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			//TODO 중복된 storeInfo가 있을 경우 에러를 강제로 발생시키는게 아니라 update구문으로 변경하거나 혹은 사전에 방어 소스가 필요함
			STOREINFO storeInfo = storeDao.select(conn, storeReq.getManageNo());
			if(storeInfo != null) {
				storeDao.updateApi(conn, new STOREINFO(storeReq.getStoreNo(), storeReq.getStoreName(),storeReq.getStorePic(),
						storeReq.getAddress(), storeReq.getHours(), storeReq.getCloseDays(), storeReq.getCallNumber(), storeReq.getManageNo()));
			}
			
			storeDao.insert(conn, new STOREINFO(0, storeReq.getStoreName(), null, storeReq.getAddress(), null, null, storeReq.getCallNumber(), storeReq.getManageNo()));
			conn.commit();
			
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
