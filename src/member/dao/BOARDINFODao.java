package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.BOARDINFO;

public class BOARDINFODao {

	public BOARDINFO selectById(Connection conn, String boardNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from BOARDINFO where BOARDNO = ?");
			pstmt.setString(1, boardNo);
			rs = pstmt.executeQuery();
			BOARDINFO boardinfo = null;
			if (rs.next()) {
				boardinfo = new BOARDINFO(
						rs.getInt("boardNo"),
						rs.getInt("userNo"), 
						rs.getString("boardTitle"),
						rs.getString("boardContents"), 
						rs.getString("boardPic"), 
						rs.getInt("viewCount"),
						toDate(rs.getTimestamp("regdate")));
			}
			return boardinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}




	public void insert(Connection conn, BOARDINFO boardinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into boardinfo values(BOARDNUM.NEXTVAL,?,?,?,?,?,?)")) {

			pstmt.setInt(1, boardinfo.getUserNo());
			pstmt.setString(2, boardinfo.getBoardTitle());
			pstmt.setString(3, boardinfo.getBoardContents());
			pstmt.setString(4, boardinfo.getBoardPic());
			pstmt.setInt(5, boardinfo.getViewCount());
			pstmt.setTimestamp(4, new Timestamp(boardinfo.getBoardDate().getTime()));
	

			pstmt.executeUpdate();
		}
	}

	/*
	 * public void update(Connection conn, boardinfo boardinfo) throws SQLException
	 * { try (PreparedStatement pstmt = conn.prepareStatement(
	 * "update boardinfo set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
	 * pstmt.setString(1, boardinfo.getName()); pstmt.setString(2,
	 * boardinfo.getPassword()); pstmt.setString(3, boardinfo.getUserId());
	 * pstmt.executeUpdate(); } }
	 */
}





