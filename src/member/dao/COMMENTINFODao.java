package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.COMMENTINFO;

public class COMMENTINFODao {

	public COMMENTINFO selectById(Connection conn, String boardNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from COMMENTINFO where BOARDNO = ?");
			pstmt.setString(1, boardNo);
			rs = pstmt.executeQuery();
			COMMENTINFO commentinfo = null;
			if (rs.next()) {
				commentinfo = new COMMENTINFO(
						rs.getInt("boardNo"),
						rs.getInt("commentNo"), 
						rs.getInt("userNo"),
						rs.getString("commentContents"), 
						toDate(rs.getTimestamp("commentDate")));
			}
			return commentinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}




	public void insert(Connection conn, COMMENTINFO commentinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into commentinfo values(?,COMMENTNUM.NEXTVAL,?,?,?)")) {

			pstmt.setInt(1, commentinfo.getBoardNo());
			pstmt.setInt(2, commentinfo.getUserNo());
			pstmt.setString(3, commentinfo.getCommentContents());
			pstmt.setTimestamp(4, new Timestamp(commentinfo.getCommentDate().getTime()));
	

			pstmt.executeUpdate();
		}
	}

	/*
	 * public void update(Connection conn, commentinfo commentinfo) throws SQLException
	 * { try (PreparedStatement pstmt = conn.prepareStatement(
	 * "update commentinfo set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
	 * pstmt.setString(1, commentinfo.getName()); pstmt.setString(2,
	 * commentinfo.getPassword()); pstmt.setString(3, commentinfo.getUserId());
	 * pstmt.executeUpdate(); } }
	 */
}





