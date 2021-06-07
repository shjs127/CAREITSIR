package member.model;

import java.util.Date;

public class REVIEWINFO {

	private int reviewNo;
	private int userNo;
	private int storeNo;
	private int avgScore;
	private String reviewContents;
	private Date reviewDate;
	
	public REVIEWINFO(int reviewNo, int userNo, int storeNo, int avgScore, String reviewContents, Date reviewDate) {

		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.storeNo = storeNo;
		this.avgScore = avgScore;
		this.reviewContents = reviewContents;
		this.reviewDate = reviewDate;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public int getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
}
	
	