package org.factory.factory;

import org.factory.connector.ConnectionMaker;
import org.factory.connector.ConnectionMakerImpl;
import org.factory.connector.CountingConnectionMaker;
import org.factory.persistence.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // application context/bean factory에서 사용할 설정정보라는 표시
public class DaoFactory {
	@Bean // 객체 생성을 담당하는 IoC용 메서드라는 표시
	public UserDao userDao() {
//		return new UserDao(connectionMaker());
		// using setter instead of constructor in UserDao
		UserDao dao = new UserDao(); // calls default constructor of UserDao
		dao.setConnectionMaker(connectionMaker()); // calls setter in UserDao, offers DaoFactory.connectionMaker() as parameter
		return dao;
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}
	
	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new ConnectionMakerImpl();
	}
}
