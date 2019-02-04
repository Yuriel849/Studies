package org.factory.factory;

import org.factory.connector.ConnectionMaker;
import org.factory.connector.ConnectionMakerImpl;
import org.factory.persistence.UserDao;

// DaoFactory를 application context/bean factory용 설정파일로 변경하기 전 코드! 이제는 사용하지 않는다!
public class DaoFactory_original {
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	
	private ConnectionMaker connectionMaker() {
		return new ConnectionMakerImpl();
	}
}
