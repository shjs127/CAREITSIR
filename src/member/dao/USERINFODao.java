package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.USERINFO;

public class USERINFODao {

	public USERINFO selectById(Connection conn, String userId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from USERINFO where USERID = ?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			USERINFO userinfo = null;
			if (rs.next()) {
				userinfo = new USERINFO(
						rs.getInt("userNo"),
						rs.getString("userId"), 
						rs.getString("password"),
						rs.getString("userName"), 
						rs.getString("nickName"), 
						rs.getString("birth"),
						rs.getString("email"),
						rs.getString("gender"),
						rs.getString("administer"));
			}
			return userinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}



	public void insert(Connection conn, USERINFO userinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into USERINFO values(USERNUM.NEXTVAL,?,?,?,?,sysdate,?,?,?)")) {

			pstmt.setString(1, userinfo.getUserId());
			pstmt.setString(2, userinfo.getPassword());
			pstmt.setString(3, userinfo.getName());
			pstmt.setString(4, userinfo.getNickName());
			//pstmt.setString(5, mem.getBirth());
			pstmt.setString(5, userinfo.getEmail());
			pstmt.setString(6, userinfo.getGender());
			pstmt.setString(7, userinfo.getAdminister());
	

			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, USERINFO userinfo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update USERINFO set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
			pstmt.setString(1, userinfo.getName());
			pstmt.setString(2, userinfo.getPassword());
			pstmt.setString(3, userinfo.getUserId());
			pstmt.executeUpdate();
		}
	}
}





