package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import member.dao.BOARDINFODao;
import member.model.BOARDINFO;

public class ListArticleService {

	private BOARDINFODao boardInfoDao = new BOARDINFODao();
	private int size = 10;

	public ArticlePage getArticlePage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = boardInfoDao.selectCount(conn);
			List<BOARDINFO> boardList = boardInfoDao.select(
					conn, (pageNum - 1) * size, size);
			return new ArticlePage(total, pageNum, size, boardList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
