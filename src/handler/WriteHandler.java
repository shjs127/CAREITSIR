package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import service.ListArticleService;

public class WriteHandler implements CommandHandler {

	private ListArticleService listService = new ListArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 	throws Exception {
	req.setCharacterEncoding("UTF-8");
	HttpSession session = req.getSession();
	String sessionID = (String) session.getAttribute("sessionID");
	if (sessionID == null) {
		sessionID = "비회원";
	}

	String boardTitle = req.getParameter("boardTitle");
	String boardContents = req.getParameter("boardContents");
	int userNo = 1;

	BoardDao boardDao = BoardDao.getInstance();
	BoardDto boardDto = new BoardDto();
	boardDto.setBoardNo(boardDao.nextval() + 1);
	boardDto.setBoardTitle(boardTitle);
	boardDto.setBoardContents(boardContents);
	boardDto.setUserNo(userNo);

	int wResult = boardDao.write(boardDto);
	System.out.println(wResult);
	resp.sendRedirect("board.do");
}

}