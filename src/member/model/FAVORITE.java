package member.model;

import java.util.Date;

public class FAVORITE {

	private int userNo;
	private int storeNo;
	private String favoriteCheck;

	public FAVORITE(int userNo, int storeNo, String favoriteCheck) {

		this.userNo = userNo;
		this.storeNo = storeNo;
		this.favoriteCheck = favoriteCheck;
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

	public String getFavoriteCheck() {
		return favoriteCheck;
	}

	public void setFavoriteCheck(String favoriteCheck) {
		this.favoriteCheck = favoriteCheck;
	}

	
}