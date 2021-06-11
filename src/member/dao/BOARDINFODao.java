package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import member.model.BOARDINFO;

public class BOARDINFODao {
	
	// 게시글 insert
	public BOARDINFO insert(Connection conn, BOARDINFO boardinfo) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("insert into boardinfo values(BOARDNO.NEXTVAL,?,?,?,?,0,?)"); 
			pstmt.setInt(1, boardinfo.getUserNo());
			pstmt.setString(2, boardinfo.getBoardTitle());
			pstmt.setString(3, boardinfo.getBoardContents());
			pstmt.setString(4, boardinfo.getBoardPic());
//			pstmt.setInt(5, boardinfo.getViewCount());
			pstmt.setTimestamp(5, new Timestamp(boardinfo.getBoardDate().getTime()));
			int insertedCount = pstmt.executeUpdate();
			
			
			if(insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from boardinfo");
				if(rs.next()) {
					Integer newNo = rs.getInt(1);
					return new BOARDINFO(newNo,
							boardinfo.getUserNo(),
							boardinfo.getBoardTitle(),
							boardinfo.getBoardContents(),
							boardinfo.getBoardPic(),
							0,
							boardinfo.getBoardDate());
				}
			}
			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from boardinfo");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<BOARDINFO> select(Connection conn, int startRow, int size) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from ( "
					+ "select row_number() over(order by boardno) num, boardinfo.* "
					+ "from boardinfo order by boardno desc) "
					+ "where num between ? and ? ");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<BOARDINFO> result = new ArrayList<>();
			while(rs.next()) {
				result.add(convertBoard(rs));
			}
			return result;
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private BOARDINFO convertBoard(ResultSet rs) throws SQLException {
		return new BOARDINFO(rs.getInt("boardno"),
							 rs.getInt("userno"),
							 rs.getString("boardtitle"),
							 rs.getString("boardcontents"),
							 rs.getString("boardpic"),
							 rs.getInt("viewcount"),
							 rs.getDate("boarddate"));
	}
	
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
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
				boardinfo = convertBoard(rs);
			}
			return boardinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void increaseReadCount(Connection conn, int boardno) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update boardinfo set veiwcount = veiwcount + 1 "+
						"where boardno = ?")) {
			pstmt.setInt(1, boardno);
			pstmt.executeUpdate();
		}
	}
	
	
//	public BOARDINFO selectById(Connection conn, String boardNo) throws SQLException {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(
//					"select * from BOARDINFO where BOARDNO = ?");
//			pstmt.setString(1, boardNo);
//			rs = pstmt.executeQuery();
//			BOARDINFO boardinfo = null;
//			if (rs.next()) {
//				boardinfo = new BOARDINFO(
//						rs.getInt("boardNo"),
//						rs.getInt("userNo"), 
//						rs.getString("boardTitle"),
//						rs.getString("boardContents"), 
//						rs.getString("boardPic"), 
//						rs.getInt("viewCount"),
//						toDate(rs.getTimestamp("regdate")));
//			}
//			return boardinfo;
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//	}


//	private Date toDate(Timestamp date) {
//		return date == null ? null : new Date(date.getTime());
//	}




//	public void insert(Connection conn, BOARDINFO boardinfo) throws SQLException {
//		try (PreparedStatement pstmt = 
//				conn.prepareStatement("insert into boardinfo values(BOARDNUM.NEXTVAL,?,?,?,?,?,?)")) {
//
//			pstmt.setInt(1, boardinfo.getUserNo());
//			pstmt.setString(2, boardinfo.getBoardTitle());
//			pstmt.setString(3, boardinfo.getBoardContents());
//			pstmt.setString(4, boardinfo.getBoardPic());
//			pstmt.setInt(5, boardinfo.getViewCount());
//			pstmt.setTimestamp(4, new Timestamp(boardinfo.getBoardDate().getTime()));
//	
//
//			pstmt.executeUpdate();
//		}
//	}

	/*
	 * public void update(Connection conn, boardinfo boardinfo) throws SQLException
	 * { try (PreparedStatement pstmt = conn.prepareStatement(
	 * "update boardinfo set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
	 * pstmt.setString(1, boardinfo.getName()); pstmt.setString(2,
	 * boardinfo.getPassword()); pstmt.setString(3, boardinfo.getUserId());
	 * pstmt.executeUpdate(); } }
	 */
}





