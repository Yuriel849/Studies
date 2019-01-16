/* The DAO for the LoginAction servlets to use,
 *     contains the "SELECT BY ID" & "SELECT *" queries.
 */

package login;

import java.util.ArrayList;
import java.util.List;

public class UserDAO extends Dao {	
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
	
    List<User> selectAllUsers() {
    	String query = "SELECT * FROM book_ex.user_info;";
    	
    	try {
    		if(conn == null) {
    			new Dao();
    		}
    		pstmt= conn.prepareStatement(query);
    		rs = pstmt.executeQuery();
    		
    		List<User> list = new ArrayList<>();
    		while (rs.next()) {
    			String user_id = rs.getString(1);
    			String password = rs.getString(2);
    			String name = rs.getString(3);
    			String email = rs.getString(4);
    			String in_date = rs.getString(5);
    			String up_date = rs.getString(6);
    			list.add(new User(user_id, password, name, email, in_date, up_date));
    		}
    		return list;
    	} catch(Exception e) {
    		e.printStackTrace();
       	}
		return null;
    }

    User selectUser(String uId) {
    	String query = "SELECT * FROM book_ex.user_info WHERE user_id='" +uId+ "';";
    	
    	try {
    		if(conn == null) {
    			new Dao();
    		}
    		pstmt= conn.prepareStatement(query);  		
    		rs = pstmt.executeQuery();
    		
    		while (rs.next()) { 
    			String user_id = rs.getString(1);
    			String password = rs.getString(2);
    			String name = rs.getString(3);
    			String email = rs.getString(4);
    			String in_date = rs.getString(5);
    			String up_date = rs.getString(6);
    			return new User(user_id, password, name, email, in_date, up_date);
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
       	}
		return null;
    }
}