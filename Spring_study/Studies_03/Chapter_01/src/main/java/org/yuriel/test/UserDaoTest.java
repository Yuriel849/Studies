package org.yuriel.test;

import java.sql.SQLException;

import org.yuriel.connector.ConnectionMaker;
import org.yuriel.connector.ConnectionMakerImpl;
import org.yuriel.domain.User;
import org.yuriel.persistence.UserDao;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMaker = new ConnectionMakerImpl();
		
		UserDao dao = new UserDao(connectionMaker);
		
		User user = new User();
		user.setId("leopard");
		user.setName("춘야");
		user.setPassword("winter_night");
		
		dao.addUser(user);
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.getUser(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회 성공");
	}
}
