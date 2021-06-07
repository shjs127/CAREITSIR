package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.FAVORITE;

public class FAVORITEDao {

	public FAVORITE selectById(Connection conn, String userNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from FAVORITE where USERNO = ?");
			pstmt.setString(1, userNo);
			rs = pstmt.executeQuery();
			FAVORITE favorite = null;
			if (rs.next()) {
				favorite = new FAVORITE(
						rs.getInt("userNo"),
						rs.getInt("storeNo"), 
						rs.getString("favoriteCheck"));
			}
			return favorite;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	public void insert(Connection conn, FAVORITE favorite) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into favorite values(?,?,?)")) {

			pstmt.setInt(1, favorite.getUserNo());
			pstmt.setInt(2, favorite.getStoreNo());
			pstmt.setString(3, favorite.getFavoriteCheck());

	

			pstmt.executeUpdate();
		}
	}

	/*
	 * public void update(Connection conn, favorite favorite) throws SQLException
	 * { try (PreparedStatement pstmt = conn.prepareStatement(
	 * "update favorite set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
	 * pstmt.setString(1, favorite.getName()); pstmt.setString(2,
	 * favorite.getPassword()); pstmt.setString(3, favorite.getUserId());
	 * pstmt.executeUpdate(); } }
	 */
}





