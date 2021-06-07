package member.model;

import java.util.Date;

public class DETAILINFO {

	private int storeNo;
	private int totalSeat;
	private int socketSeat;
	private String dessertSales;
	private String terrace;
	private String roofTop;
	private String wifi;
	private String companionDog;
	private String parkingSpace;
	private String noKidsZone;
	private String smokingArea;
	
	public DETAILINFO(int storeNo, int totalSeat, int socketSeat, String dessertSales, String terrace, String roofTop,
			String wifi, String companionDog, String parkingSpace, String noKidsZone, String smokingArea) {

		this.storeNo = storeNo;
		this.totalSeat = totalSeat;
		this.socketSeat = socketSeat;
		this.dessertSales = dessertSales;
		this.terrace = terrace;
		this.roofTop = roofTop;
		this.wifi = wifi;
		this.companionDog = companionDog;
		this.parkingSpace = parkingSpace;
		this.noKidsZone = noKidsZone;
		this.smokingArea = smokingArea;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getSocketSeat() {
		return socketSeat;
	}

	public void setSocketSeat(int socketSeat) {
		this.socketSeat = socketSeat;
	}

	public String getDessertSales() {
		return dessertSales;
	}

	public void setDessertSales(String dessertSales) {
		this.dessertSales = dessertSales;
	}

	public String getTerrace() {
		return terrace;
	}

	public void setTerrace(String terrace) {
		this.terrace = terrace;
	}

	public String getRoofTop() {
		return roofTop;
	}

	public void setRoofTop(String roofTop) {
		this.roofTop = roofTop;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getCompanionDog() {
		return companionDog;
	}

	public void setCompanionDog(String companionDog) {
		this.companionDog = companionDog;
	}

	public String getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(String parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public String getNoKidsZone() {
		return noKidsZone;
	}

	public void setNoKidsZone(String noKidsZone) {
		this.noKidsZone = noKidsZone;
	}

	public String getSmokingArea() {
		return smokingArea;
	}

	public void setSmokingArea(String smokingArea) {
		this.smokingArea = smokingArea;
	}
	
	
}