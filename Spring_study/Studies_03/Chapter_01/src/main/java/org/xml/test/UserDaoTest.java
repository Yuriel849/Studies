package org.xml.test;

import java.sql.SQLException;

import org.factory.domain.User;
import org.xml.persistence.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		@SuppressWarnings("resource")
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class); // @Bean 붙은 메서드 중 "userDao"를 호출하고 , 반환값의 타입은 UserDao이어야 한다!
			// 단순한 오브젝트 팩토리와 달리 application context는 단 하나의 인스턴스만 생성하며, getBean()은 동일한 인스턴스를 반환한다!
		
		User user = new User();
		
		for(int i = 0; i < 10; i++) {
			user.setId("3rd_test " + i);
			user.setName("another_testee - " + i);
			user.setPassword("grant_code - " + i);
			dao.addUser(user);
			System.out.println(user.getId() + " 등록 성공");

			User user2 = dao.getUser(user.getId());
			System.out.println(user2.getName());
			System.out.println(user2.getPassword());
			System.out.println(user2.getId() + " 조회 성공");
		}
	}
}
