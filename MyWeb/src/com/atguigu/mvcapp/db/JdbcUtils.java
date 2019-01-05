package com.atguigu.mvcapp.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 
 * JDBC
 */
public class JdbcUtils {
	
	public static void releaseConnection(Connection connection){
		try {
			
			if(connection != null){
				connection.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static DataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
}
