/* A DTO for the SignUpAction.java servlet,
 * 	   contains only the "INSERT" query.
 */
package join;


public class UserDAO extends DAO {
	private static UserDAO udao = new UserDAO();

	private UserDAO() {
		super(null,"");
	}
	
	public static UserDAO getInstance() {
		if(udao == null) {
			udao = new UserDAO();
		}
		return udao;
	}
	
	public int join(User user) {
		String SQL = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserID());
			pstmt.setString(3, user.getUserPwd());
			pstmt.setString(4, user.getUserSN());
			pstmt.setString(5, user.getUserPost());
			pstmt.setString(6, user.getUserAddr());
			pstmt.setString(7, user.getUserJob());
			pstmt.setString(8, user.getUserHobbies());
			pstmt.setString(9, user.getUserText());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // "DB 오류"를 의미하도록
	}
}