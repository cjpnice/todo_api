package com.cjpnice.todo.config;



import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Configuration
@Order(1)
@WebFilter(filterName = "urlFilter", urlPatterns = "/api/*")
public class UrlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String servletPath = httpRequest.getServletPath();
        if (StringUtils.isNotBlank(servletPath) && servletPath.startsWith("/api")) {
            String newPath = servletPath.substring(4);
            request.getRequestDispatcher(newPath).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
