package com.servlet.Servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class loginServletG extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        System.out.println(method);
        //太麻烦

    }
}
