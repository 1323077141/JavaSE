package com.authority;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class AuthorityServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into AuthorityServlet");
        String methodName = req.getParameter("method");
        try {
            Method method = getClass().getMethod(methodName,
                    HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private UserDao userDao = new UserDao();

    public void getAuthorities(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = userDao.get(username);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/authority-manager.jsp").forward(req,resp);
    }





}
