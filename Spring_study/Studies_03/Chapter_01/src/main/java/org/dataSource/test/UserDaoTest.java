package org.dataSource.test;

import java.sql.SQLException;

import org.factory.connector.CountingConnectionMaker;
import org.factory.domain.User;
import org.factory.factory.DaoFactory;
import org.factory.persistence.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// TEST USING DATASOURCE AND DAOFACTORY

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//		UserDao dao = context.getBean("userDao", UserDao.class); // @Bean 붙은 메서드 중 "userDao"를 호출하고 , 반환값의 타입은 UserDao이어야 한다!
//			// 단순한 오브젝트 팩토리와 달리 application context는 단 하나의 인스턴스만 생성하며, getBean()은 동일한 인스턴스를 반환한다!
		
		// application context/bean factory 사용하니까 불필요하다.
		UserDao dao = new DaoFactory().userDao();
		
		// factory 사용하니까 불필요하다.
//		ConnectionMaker connectionMaker = new ConnectionMakerImpl();
//		UserDao dao = new UserDao(connectionMaker);
		
		User user = new User();
		
		for(int i = 0; i < 10; i++) {
			user.setId("4th_test " + i);
			user.setName("use DataSource - " + i);
			user.setPassword("DS_code - " + i);
			dao.addUser(user);
			System.out.println(user.getId() + " 등록 성공");

			User user2 = dao.getUser(user.getId());
			System.out.println(user2.getName());
			System.out.println(user2.getPassword());
			System.out.println(user2.getId() + " 조회 성공");
		}
	}
}
