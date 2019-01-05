package com.atguigu.mvcapp.servlet;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.atguigu.mvcapp.dao.factory.CustomerDAOFactory;

public class InitServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		CustomerDAOFactory.getInstance().setType("jdbc");
		
		InputStream in =
				getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			String type = properties.getProperty("type");
			CustomerDAOFactory.getInstance().setType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
