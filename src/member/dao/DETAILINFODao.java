package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.DETAILINFO;

public class DETAILINFODao {

	public DETAILINFO selectById(Connection conn, String storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from DETAILINFO where STORENO = ?");
			pstmt.setString(1, storeNo);
			rs = pstmt.executeQuery();
			DETAILINFO detailinfo = null;
			if (rs.next()) {
				detailinfo = new DETAILINFO(
						rs.getInt("storeNo"),
						rs.getInt("totalSeat"), 
						rs.getInt("socketSeat"),
						rs.getString("dessertSales"), 
						rs.getString("terrace"),
						rs.getString("roofTop"),
						rs.getString("wifi"),
						rs.getString("companionDog"),
						rs.getString("parkingSpace"),
						rs.getString("noKidsZone"),
						rs.getString("smokingArea"));
			}
			return detailinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}




	public void insert(Connection conn, DETAILINFO detailinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into detailinfo values(?,?,?,?,?,?,?,?,?,?,?)")) {

			pstmt.setInt(1, detailinfo.getStoreNo());
			pstmt.setInt(2, detailinfo.getTotalSeat());
			pstmt.setInt(3, detailinfo.getSocketSeat());
			pstmt.setString(4, detailinfo.getDessertSales());
			pstmt.setString(5, detailinfo.getTerrace());
			pstmt.setString(6, detailinfo.getRoofTop());
			pstmt.setString(7, detailinfo.getWifi());
			pstmt.setString(8, detailinfo.getCompanionDog());
			pstmt.setString(9, detailinfo.getParkingSpace());
			pstmt.setString(10, detailinfo.getNoKidsZone());
			pstmt.setString(11, detailinfo.getSmokingArea());
	
			pstmt.executeUpdate();
		}
	}

	/*
	 * public void update(Connection conn, detailinfo detailinfo) throws SQLException
	 * { try (PreparedStatement pstmt = conn.prepareStatement(
	 * "update detailinfo set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
	 * pstmt.setString(1, detailinfo.getName()); pstmt.setString(2,
	 * detailinfo.getPassword()); pstmt.setString(3, detailinfo.getUserId());
	 * pstmt.executeUpdate(); } }
	 */
}





