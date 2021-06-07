package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.USERINFODao;
import member.model.USERINFO;

public class LoginService {

	private USERINFODao userinfoDao = new USERINFODao();

	public User login(String id, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			USERINFO userinfo = userinfoDao.selectById(conn, id);
			if (userinfo == null) {
				throw new LoginFailException();
			}
			if (!userinfo.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new User(userinfo.getUserId(), userinfo.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
