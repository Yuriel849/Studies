package login;

public class User02 {
	private String userId;
	private String password;
	private String name;
	private String email;
	private String in_date = "";
	private String up_date = "";
	
	public User02(String userId, String password, String name, String email, String in_date, String up_date) {
		super();
		this.setUserId(userId);
		this.setPassword(password);
		this.setName(name);
		this.setEmail(email);
		this.setIn_date(in_date);
		this.setUp_date(up_date);
	}

	@Override
	public String toString() {
		return "User02 [userId=" + getUserId() + ", password=" + getPassword() + ", name=" + getName()
				+ ", email=" + getEmail() + ", in_date=" + getIn_date() + ", up_date=" + getUp_date() + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIn_date() {
		return in_date;
	}

	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}

	public String getUp_date() {
		return up_date;
	}

	public void setUp_date(String up_date) {
		this.up_date = up_date;
	}
}