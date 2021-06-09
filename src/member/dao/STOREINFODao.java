package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.STOREINFO;

public class STOREINFODao {

	public STOREINFO select(Connection conn, String manageno) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from STOREINFO where manageno = ?");
			pstmt.setString(1, manageno);
			rs = pstmt.executeQuery();
			STOREINFO storeinfo = null;
			
			if (rs.next()) {
				storeinfo = new STOREINFO(
						rs.getInt("storeNo"),
						rs.getString("storeName"), 
						rs.getString("storePic"),
						rs.getString("address"), 
						rs.getString("hours"), 
						rs.getString("closedDays"),
						rs.getString("callNumber"),
						rs.getString("manageNo"));
			}
			return storeinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void insert(Connection conn, STOREINFO storeinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into storeinfo  (storeno, storename, address, callnumber, manageno) values(STORENUM.NEXTVAL,?,?,?,?)")) {
			pstmt.setString(1, storeinfo.getStoreName());
			pstmt.setString(2, storeinfo.getAddress());
			pstmt.setString(3, storeinfo.getCallNumber());
			pstmt.setString(4, storeinfo.getManageNo());
			pstmt.executeUpdate();
		}
	}

	
	public void update(Connection conn, STOREINFO storeinfo) throws SQLException{
		try(PreparedStatement pstmt = conn.prepareStatement("update storeinfo set storename = ?, storepic = ?, address = ?,"
				+ "hours = ?, closedays = ?, callnumber = ? ")){
			pstmt.setString(1, storeinfo.getStoreName());
			pstmt.setString(2, storeinfo.getStorePic());
			pstmt.setString(3, storeinfo.getAddress());
			pstmt.setString(4, storeinfo.getHours());
			pstmt.setString(5, storeinfo.getClosedDays());
			pstmt.setString(6, storeinfo.getCallNumber());
			
			pstmt.executeUpdate();
		}
	}
	
	/*
	 * public void update(Connection conn, STOREINFO storeinfo) throws SQLException
	 * { try (PreparedStatement pstmt = conn.prepareStatement(
	 * "update storeinfo set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
	 * pstmt.setString(1, storeinfo.getName()); pstmt.setString(2,
	 * storeinfo.getPassword()); pstmt.setString(3, storeinfo.getUserId());
	 * pstmt.executeUpdate(); } }
	 */
}





