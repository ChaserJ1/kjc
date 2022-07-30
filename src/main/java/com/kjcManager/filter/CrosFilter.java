package com.kjcManager.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;

            String origin = ((HttpServletRequest) request).getHeader("Origin");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", origin == null ? "" : origin);
            httpServletResponse.setHeader("Access-Control-Allow-Methods","POST, GET");//允许跨域的请求方式
            httpServletResponse.setHeader("Access-Control-Max-Age", "3600");//预检请求的间隔时间
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-auth-token,Origin,Access-Token,X-Requested-With,Content-Type, Accept,token" );//允许跨域请求携带的请求头

            httpServletResponse.setHeader("strict-transport-security","max-age=16070400; includeSubDomains");//简称为HSTS。它允许一个HTTPS网站，要求浏览器总是通过HTTPS来访问它
            httpServletResponse.setHeader("Content-Security-Policy", "default-src 'self'; script-src 'self'; frame-ancestors 'self'; object-src 'none'");//这个响应头主要是用来定义页面可以加载哪些资源，减少XSS的发生
            httpServletResponse.setHeader("X-Content-Type-Options", "nosniff");//互联网上的资源有各种类型，通常浏览器会根据响应头的Content-Type字段来分辨它们的类型。通过这个响应头可以禁用浏览器的类型猜测行为
            httpServletResponse.setHeader("X-XSS-Protection", "1; mode=block");//1; mode=block：启用XSS保护，并在检查到XSS攻击时，停止渲染页面
            httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN");//SAMEORIGIN：不允许被本域以外的页面嵌入
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
