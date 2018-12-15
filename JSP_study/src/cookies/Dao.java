package cookies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8";
	String DB_USER = "student1234";  // DB�� user ID�� password�� �˸°� ����
	String DB_PASSWORD = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String tableName = "";
	 
	Dao() {
		this(null, "");
	}
	 
	Dao(String tableName) {
		this(null, tableName);
	}
	 
	Dao(Connection conn, String tableName) {
		if(conn != null) {
			this.conn = conn;
		} else {
			this.conn = getConnection();
		}
		this.tableName = tableName;
	}
	
	Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,  DB_USER, DB_PASSWORD); // �����ͺ��̽��� ������ �Ͽ� �� ������ "conn" ���������� �ٷ��.
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	 
	void rollback(){
		if(conn!=null) {
			try {
				conn.rollback();
			} catch(SQLException e){ }
		}
	}
 
	void close(AutoCloseable... acs) {
		try {
			for(AutoCloseable auto : acs) {
				auto.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
} // Dao 클래스 끝.