/* Responsible for loading the JDBC driver and obtaining a connection to the MySQL DB */

package join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	String DB_URL = "jdbc:mysql://localhost:3306/BBS?useUnicode=true&characterEncoding=utf8";
	String DB_USER = "System";
	String DB_PASSWORD = "IriDesCence";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String tableName = "";
	 
	DAO() {
		this(null, "");
	}
	 
	DAO(String tableName) {
		this(null, tableName);
	}
	 
	DAO(Connection conn, String tableName) {
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
			conn = DriverManager.getConnection(DB_URL,  DB_USER, DB_PASSWORD); // 데이터베이스와 연결을 하여 그 연결을 "conn" 참조변수로 다룬다.
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
} // JoinDAO 클래스 끝.