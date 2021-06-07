package member.model;

import java.util.Date;

public class COMMENTINFO {

	private int boardNo;
	private int commentNo;
	private int userNo;
	private String commentContents;
	private Date commentDate;

	public COMMENTINFO(int boardNo, int commentNo, int userNo, String commentContents, Date commentDate) {

		this.boardNo = boardNo;
		this.commentNo = commentNo;
		this.userNo = userNo;
		this.commentContents = commentContents;
		this.commentDate = commentDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getCommentContents() {
		return commentContents;
	}

	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	
	

}