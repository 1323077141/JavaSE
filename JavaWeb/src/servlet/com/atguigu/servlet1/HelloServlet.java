package servlet.com.atguigu.servlet1;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");

        String user = servletConfig.getInitParameter("name");

        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(servletConfig.getInitParameter(name));
        }

        System.out.println(servletConfig.getServletName());

        //获取ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();


    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig...");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo...");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy....");
    }

    public HelloServlet(){
        System.out.println("HelloServlet's constructor....");
    }

}
