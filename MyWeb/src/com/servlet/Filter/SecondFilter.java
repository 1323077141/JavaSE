package com.servlet.Filter;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("second init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("second filter");
    }

    @Override
    public void destroy() {
        System.out.println("second destroy");
    }
}
