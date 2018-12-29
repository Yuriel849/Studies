package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;

public class MemberDAO {
	private Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "Yuriel";
		String pwd = "Sapph1r3";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}
		return conn;
	}
	
	public List<MemberDTO> list() { // Select 쿼리문 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT name, title, salary");
		sql.append(" FROM s_emp");
		List<MemberDTO> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setSalary(rs.getInt("salary"));
				list.add(dto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			if(pstmt != null) try{ pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try{ conn.close(); } catch(SQLException e) {}
			if(rs != null) try{ rs.close(); } catch(SQLException e) {}
		}
		return list;
	}
}
