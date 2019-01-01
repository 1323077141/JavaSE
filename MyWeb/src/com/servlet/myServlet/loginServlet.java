package com.servlet.myServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

        //获取客户端真实IP(在Tomcat或者Nginx的反向代理后，IP会发生变化,getRemoteAddr()获取到的是反向代理的IP)

        String ipStr = httpServletRequest.getRemoteAddr();
        if (ipStr == null || ipStr.length() == 0 || "unkown".equalsIgnoreCase(ipStr)){
            ipStr = httpServletRequest.getHeader("X-FORWARDED-FOR ");
            //通过了HTTP代理或者负载均衡服务器时才会添加该项
            //格式为X-Forwarded-For:client1,proxy1,proxy2，
            // 一般情况下，第一个ipStr为客户端真实ipStr，后面的为经过的代理服务器ipStr。
        }else if (ipStr == null || ipStr.length() == 0 || "unkown".equalsIgnoreCase(ipStr)){
            ipStr = httpServletRequest.getHeader("Proxy-Client-IP");
            //这个一般是经过apache http服务器的请求才会有，用apache http做代理时一般会加上Proxy-Client-IP请求头

        }else if (ipStr == null || ipStr.length() == 0 || "unkown".equalsIgnoreCase(ipStr)){

            ipStr = httpServletRequest.getHeader("WL-Proxy-Client-IP");
            // 而WL-Proxy-Client-IP是apache http服务器的weblogic插件加上的头

        }else if (ipStr == null || ipStr.length() == 0 || "unkown".equalsIgnoreCase(ipStr)){
            ipStr = httpServletRequest.getHeader("HTTP_CLIENT_IP");
            //有些代理服务器会加上此请求头

        }else if (ipStr == null || ipStr.length() == 0 || "unkown".equalsIgnoreCase(ipStr)){
            ipStr = httpServletRequest.getHeader("X-Real-IP");
            //nginx代理一般会加上此请求头

        }else{
            ipStr = httpServletRequest.getRemoteAddr();
        }
        String ip = "";
        if (ipStr != null || ipStr.length() != 0){
            if (ipStr.contains(",")){
                ip = ipStr.split(",")[0];
            }else{
                ip = ipStr;
            }
        }
        System.out.println(ip);


        //ServletResponse
        PrintWriter out = servletResponse.getWriter();
        out.print("helloworld.....");

        servletResponse.setContentType("application/msword");   //word格式

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;




    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
