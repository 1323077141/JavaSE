package com.servlet.Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 针对Http协议定义的一个servlet基类
 * 与HttpServlet相同
 */
public class MyHttpServlet extends MyGenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        if (servletRequest instanceof HttpServletRequest){
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            if (servletResponse instanceof HttpServletResponse){
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                service(request,response);
            }

        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取请求方式
        String method = request.getMethod();
        if ("GET".equalsIgnoreCase(method)){
            doGet(request,response);
        }else if ("POST".equalsIgnoreCase(method)){
            doPost(request,response);
        }
        //2.根据请求方式再创建对应的处理方法


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    }


}
