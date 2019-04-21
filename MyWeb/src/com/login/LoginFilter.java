package com.login;

import com.servlet.Filter.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class LoginFilter extends HttpFilter {
    //获取SessionKey,redirectPage,uncheckedUrls
    private String sessionKey;
    private String redirectPage;
    private String uncheckedUrls;

    @Override
    protected void init() {
//        super.init();
        ServletContext servletContext = getFilterConfig().getServletContext();
        sessionKey = servletContext.getInitParameter("userSessionKey");
        redirectPage = servletContext.getInitParameter("redirectPage");
        uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");


    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //1.获取请求的URL
        String requestUrl = request.getRequestURI().toString(); //  http:localhost:8080/web/login/list.jsp
        String requestURI = request.getRequestURI();            //  /web/login/list.jsp
        String servletPath = request.getServletPath();          //  /login/list.jsp
        System.out.println(requestUrl);
        System.out.println(requestURI);
        System.out.println(servletPath);

        //1.检查获取的servletPath是否为不需要检查的URL中，若是，则直接放行，
        List<String> urls = Arrays.asList(uncheckedUrls.split(","));
        if (urls.contains(servletPath)){
            chain.doFilter(request,response);
            return;
        }
        //3.从session中获取sessionkey对应的值，若值不存在，则重定向到redirectUrl
        Object user = request.getSession().getAttribute("sessionKey");
        if (user ==null){
            response.sendRedirect(request.getContextPath() + requestURI);
            return;
        }


        //4.若存在，则放行
        chain.doFilter(request,response);

    }
}
