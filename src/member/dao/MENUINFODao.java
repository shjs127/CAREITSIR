package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.MENUINFO;

public class MENUINFODao {

	public MENUINFO selectById(Connection conn, String storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from MENUINFO where STORENO = ?");
			pstmt.setString(1, storeNo);
			rs = pstmt.executeQuery();
			MENUINFO menuinfo = null;
			if (rs.next()) {
				menuinfo = new MENUINFO(
						rs.getInt("storeNo"),
						rs.getString("menu"),
						rs.getInt("price"), 
						rs.getString("menuPic"));
			}
			return menuinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	public void insert(Connection conn, MENUINFO menuinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into MENUINFO values(?,?,?,?)")) {

			pstmt.setInt(1, menuinfo.getStoreNo());
			pstmt.setString(2, menuinfo.getMenu());
			pstmt.setInt(3, menuinfo.getPrice());
			pstmt.setString(4, menuinfo.getMenuPic());

	

			pstmt.executeUpdate();
		}
	}

	/*
	 * public void update(Connection conn, menuinfo menuinfo) throws SQLException
	 * { try (PreparedStatement pstmt = conn.prepareStatement(
	 * "update menuinfo set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
	 * pstmt.setString(1, menuinfo.getName()); pstmt.setString(2,
	 * menuinfo.getPassword()); pstmt.setString(3, menuinfo.getUserId());
	 * pstmt.executeUpdate(); } }
	 */
}





