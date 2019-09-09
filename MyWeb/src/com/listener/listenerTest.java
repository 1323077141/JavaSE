package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class listenerTest implements ServletContextListener,ServletRequestListener,HttpSessionListener {

    /*
    * request声明周期为一个request请求的时间
    *
    *
    *
    * session生命周期:当第一次访问web应用的一个jsp或servlet时，且该jsp或servlet中需要创建session对象,此时创建session
    * session销毁：过期或者调用session的invalidate方法
    * 关闭浏览器, 并不意味着 session 被销毁, 还可以通过 sessionid 找到服务器中的 session 对象.
    *
    *
    * pplication: 贯穿于当前的 WEB 应用的生命周期. 当前 WEB 应用被加载时创建 application 对象,
    * 当前 WEB 应用被卸载时销毁 application 对象.
    *
    */


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
