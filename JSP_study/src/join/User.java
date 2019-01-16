/* A DTO for the SignUpAction.java servlet */

package join;

public class User {
	private String userName;
	private String userID;
	private String userPwd;
	private String userSN;
	private String userPost;
	private String userAddr;
	private String userJob;
	private String userHobbies;
	private String userText;
		
	// Constructor
	public User(String userName, String userID, String userPwd, String userSN, String userPost, String userAddr,
			String userJob, String userHobbies, String userText) {
		super();
		this.userName = userName;
		this.userID = userID;
		this.userPwd = userPwd;
		this.userSN = userSN;
		this.userPost = userPost;
		this.userAddr = userAddr;
		this.userJob = userJob;
		this.userHobbies = userHobbies;
		this.userText = userText;
	}

	public User() {
		super();
	}

	// Getters & Setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserSN() {
		return userSN;
	}

	public void setUserSN(String userSN) {
		this.userSN = userSN;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserJob() {
		return userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public String getUserHobbies() {
		return userHobbies;
	}

	public void setUserHobbies(String userHobbies) {
		this.userHobbies = userHobbies;
	}

	public String getUserText() {
		return userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
	}
}