package login;

import java.util.ArrayList;
import java.util.List;

public class UserDAO03 extends Dao {
	private static UserDAO03 udao = new UserDAO03();

	private UserDAO03() {
		super(null,"");
	}
	
	public static UserDAO03 getInstance() {
		if(udao == null) {
			udao = new UserDAO03();
		}
		return udao;
	}
	
    List<User02> selectAllUsers() {
    	String query = "SELECT * FROM book_ex.user_info;";
    	
    	try {
    		if(conn == null) {
    			new Dao();
    		}
    		pstmt= conn.prepareStatement(query);
    		rs = pstmt.executeQuery();
    		
    		List<User02> list = new ArrayList<>();
    		while (rs.next()) {
    			String user_id = rs.getString(1);
    			String password = rs.getString(2);
    			String name = rs.getString(3);
    			String email = rs.getString(4);
    			String in_date = rs.getString(5);
    			String up_date = rs.getString(6);
    			list.add(new User02(user_id, password, name, email, in_date, up_date));
    		}
    		return list;
    	} catch(Exception e) {
    		e.printStackTrace();
       	}
		return null;
    }

    User02 selectUser(String uId) {
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
    			return new User02(user_id, password, name, email, in_date, up_date);
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
       	}
		return null;
    }
}