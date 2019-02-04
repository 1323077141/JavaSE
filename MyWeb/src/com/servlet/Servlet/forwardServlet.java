package com.servlet.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class forwardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ForwardServlet's doGet");

        //请求的转发:
        //1.调用HttpServletRequest的 getRequestDispatcher  方法获取RequestDispatcher 对象
        //调用 getRequestDispatcher() 需要传入要转发的地址
        String path = "/testServlet";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);

        //2.调用HttpServletRequest 的forward(request,response) 进行请求的转发
        requestDispatcher.forward(request,response);

    }

}
