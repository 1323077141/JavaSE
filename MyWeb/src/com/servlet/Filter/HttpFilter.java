package com.servlet.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义HttpFilter,实现来自Filter接口
 */
public abstract class HttpFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        init();
    }

    /**
     * 供子类初始化
     */
    protected void init(){}

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        doFilter(request,response,filterChain);
    }

    public abstract void doFilter(HttpServletRequest request,
                                  HttpServletResponse response,FilterChain chain)
            throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}
