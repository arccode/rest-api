package com.arccode.web.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CrosFilter : 跨域资源共享过滤器, 该过滤器设置response header, 解决跨域ajax请求报错
 *
 * @author arccode
 * @since 2014-12-07 22:04
 */
@Component
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse)res;
        // 允许所有域进行访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许的方法
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Cache-Control");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
