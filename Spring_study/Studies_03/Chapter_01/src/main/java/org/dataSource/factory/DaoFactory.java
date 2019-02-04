package org.dataSource.factory;

import javax.sql.DataSource;

import org.dataSource.persistence.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration // application context/bean factory에서 사용할 설정정보라는 표시
public class DaoFactory {
	@Bean // 객체 생성을 담당하는 IoC용 메서드라는 표시
	public UserDao userDao() {
		UserDao dao = new UserDao();
		dao.setDataSource(dataSource());
		return dao;
	}
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/spring");
		dataSource.setUsername("Yuriel");
		dataSource.setPassword("Sapph1r3");
		
		return (DataSource) dataSource;
	}
}
