package org.xml.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMakerImpl implements ConnectionMaker {
	@Override
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/spring?useSSL=false&amp;serverTimezone=UTC", "Yuriel", "Sapph1r3");
		return conn;
	}
}
