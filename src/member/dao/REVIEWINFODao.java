package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.REVIEWINFO;

public class REVIEWINFODao {

	public REVIEWINFO selectById(Connection conn, String reviewNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from REVIEWINFO where REVIEWNO = ?");
			pstmt.setString(1, reviewNo);
			rs = pstmt.executeQuery();
			REVIEWINFO reviewinfo = null;
			if (rs.next()) {
				reviewinfo = new REVIEWINFO(
						rs.getInt("reviewNo"),
						rs.getInt("userNo"), 
						rs.getInt("storeNo"),
						rs.getInt("avgScore"), 
						rs.getString("reviewContents"), 
						toDate(rs.getTimestamp("reviewDate")));
			}
			return reviewinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}




	public void insert(Connection conn, REVIEWINFO reviewinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into reviewinfo values(REVIEWNUM.NEXTVAL,?,?,?,?,?)")) {

			pstmt.setInt(1, reviewinfo.getReviewNo());
			pstmt.setInt(2, reviewinfo.getUserNo());
			pstmt.setInt(3, reviewinfo.getStoreNo());
			pstmt.setInt(4, reviewinfo.getAvgScore());
			pstmt.setString(5, reviewinfo.getReviewContents());
			pstmt.setTimestamp(6, new Timestamp(reviewinfo.getReviewDate().getTime()));
	

			pstmt.executeUpdate();
		}
	}

	/*
	 * public void update(Connection conn, reviewinfo reviewinfo) throws SQLException
	 * { try (PreparedStatement pstmt = conn.prepareStatement(
	 * "update reviewinfo set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
	 * pstmt.setString(1, reviewinfo.getName()); pstmt.setString(2,
	 * reviewinfo.getPassword()); pstmt.setString(3, reviewinfo.getUserId());
	 * pstmt.executeUpdate(); } }
	 */
}





