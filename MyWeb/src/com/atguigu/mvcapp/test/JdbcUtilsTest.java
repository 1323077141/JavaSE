package com.atguigu.mvcapp.test;

import java.sql.Connection;
import java.sql.SQLException;


import com.atguigu.mvcapp.db.JdbcUtils;
import org.junit.jupiter.api.Test;

public class JdbcUtilsTest {

	@Test
	public void testGetConnection() throws SQLException {
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
	}

}
