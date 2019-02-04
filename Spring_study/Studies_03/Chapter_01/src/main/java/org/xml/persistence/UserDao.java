package org.xml.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.xml.connector.ConnectionMaker;
import org.factory.domain.User;

public class UserDao {
	private ConnectionMaker connectionMaker;

//	public UserDao(ConnectionMaker maker) {
//		connectionMaker = maker;
//	}
	// using setter instead of constructor
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void addUser(User user) throws ClassNotFoundException, SQLException {
		Connection conn = connectionMaker.makeNewConnection();
		
		PreparedStatement ps = conn.prepareStatement("insert into toby_users(id, name, password) values (?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public User getUser(String id) throws ClassNotFoundException, SQLException {
		Connection conn = connectionMaker.makeNewConnection();		
		PreparedStatement ps = conn.prepareStatement("select * from toby_users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		conn.close();
		
		return user;
	}
	
//	// "UserDao" 클래스가 정상적으로 작동하는지 테스트하기 위해서 "셀프 테스트용 main()"를 사용한다.
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		UserDaoImpl dao = new UserDaoImpl();
//		
//		User user = new User();
//		user.setId("blue_gem");
//		user.setName("벽석");
//		user.setPassword("gemblades");
//		
//		dao.addUser(user);
//		System.out.println(user.getId() + " 등록 성공");
//		
//		User user2 = dao.getUser(user.getId());
//		System.out.println(user2.getName());
//		System.out.println(user2.getPassword());
//		System.out.println(user2.getId() + " 조회 성공");
//	}
}