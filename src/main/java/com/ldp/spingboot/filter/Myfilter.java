package com.ldp.spingboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Return
 * @create 2019-05-23 19:46
 */
public class Myfilter implements Filter {

    //初始化过滤器
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器....init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器....doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器....destroy");
    }
}
