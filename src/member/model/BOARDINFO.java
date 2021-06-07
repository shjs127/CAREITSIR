package member.model;

import java.util.Date;

public class BOARDINFO {

	private int boardNo;
	private int userNo;
	private String boardTitle;
	private String boardContents;
	private String boardPic;
	private int viewCount;
	private Date boardDate;
	
	public BOARDINFO(int boardNo, int userNo, String boardTitle, String boardContents, String boardPic, int viewCount,
			Date boardDate) {
	
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContents = boardContents;
		this.boardPic = boardPic;
		this.viewCount = viewCount;
		this.boardDate = boardDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	public String getBoardPic() {
		return boardPic;
	}

	public void setBoardPic(String boardPic) {
		this.boardPic = boardPic;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	

}