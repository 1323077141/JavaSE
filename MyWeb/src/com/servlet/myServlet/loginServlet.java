package com.servlet.myServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class loginServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String user = servletRequest.getParameter("user");
        System.out.println(user);
        String password = servletRequest.getParameter("password");
        System.out.println(password);

        String[] insteresting = servletRequest.getParameterValues("insteresting");
        for (String item: insteresting){
            System.out.println(item);
        }

        Enumeration<String> names = servletRequest.getParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name + "--->" + servletRequest.getParameter(name));
        }

        Map<String,String[]> map = servletRequest.getParameterMap();
        for (Map.Entry<String,String[]> entry : map.entrySet()){
            System.out.println("entry---" + entry.getKey() + ":" + map.get(entry.getKey()));
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String url = httpServletRequest.getRequestURI();
        System.out.println(url);

        String method = httpServletRequest.getMethod();
        System.out.println(method);

        String query = httpServletRequest.getQueryString();
        System.out.println(query); //GET时，为请求参数

        String servletPath = httpServletRequest.getServletPath();
        System.out.println(servletPath); //   /loginservlet





    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
