package com.servlet.Servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 自定义Servlet接口实现类
 * 与GenericServlet相同
 */
public abstract class MyGenericServlet implements Servlet,ServletConfig {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public abstract void service(ServletRequest servletRequest,
                        ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {}


    //==========ServletConfig接口========

    @Override
    public String getServletName() {
        return servletConfig.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return servletConfig.getServletContext();
    }

    @Override
    public String getInitParameter(String s) {
        return servletConfig.getInitParameter(s);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return servletConfig.getInitParameterNames();
    }
}
