package com.hand.common.factory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ping.an
 *获得数据路链接对象的工厂
 */
public class ConnectionFactory {
	static private String driver;
	static private String url;
	static private String user;
	static private String password;
	
	static{
		Properties properties = new Properties();
		try {
			properties.load(ConnectionFactory.class.getResourceAsStream("/myjdbc/db.properties"));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Connection getconn(){
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			//设置需要手动提交
			connection.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
