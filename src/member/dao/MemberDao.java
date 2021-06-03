package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {

	public Member selectById(Connection conn, String userId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from USERINFO where USERID = ?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(
						rs.getInt("userNo"),
						rs.getString("userId"), 
						rs.getString("name"), 
						rs.getString("password"),
						rs.getString("nickName"), 
						rs.getString("birth"),
						rs.getString("email"),
						rs.getString("gender"),
						rs.getString("adminster"));
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}



	public void insert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into USERINFO values(USERNUM.NEXTVAL,?,?,?,?,sysdate,?,?,?)")) {

			pstmt.setString(1, mem.getUserId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getNickName());
			//pstmt.setString(5, mem.getBirth());
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getGender());
			pstmt.setString(7, mem.getAdminster());
	

			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update member set name = ?, password = ? where memberid = ?")) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUserId());
			pstmt.executeUpdate();
		}
	}
}
