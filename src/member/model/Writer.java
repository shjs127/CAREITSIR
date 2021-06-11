package member.model;

public class Writer {

	private String userId;
	private String name;

	public Writer(String userId, String name) {
		this.userId = userId;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

}
