package org.yuriel.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.yuriel.domain.User;

public class UserDaoImpl extends UserDao {
	public void addUser(User user) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		PreparedStatement ps = conn.prepareStatement("insert into toby_users(id, name, password) values (?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public User getUser(String id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
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
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/spring?useSSL=false&amp;serverTimezone=UTC", "Yuriel", "Sapph1r3");
		return conn;
	}
}