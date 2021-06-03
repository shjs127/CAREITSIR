package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.xml.crypto.Data;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {

	private MemberDao memberDao = new MemberDao();

	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Member member = memberDao.selectById(conn, joinReq.getUserId());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			int x=1;
			memberDao.insert(conn, new Member(
				0,joinReq.getUserId() ,joinReq.getPassword(),joinReq.getName(),joinReq.getNickName(),joinReq.getBirth(),joinReq.getEmail(),joinReq.getGender(),"x"));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
