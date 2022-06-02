package com.kjcManager.tools;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        System.out.println(path);
        // 从session里取用户信息
        String username = (String) session.getAttribute("username");
        // 无需过滤的页面
        if(path.indexOf("/login.jsp") > -1 || path.indexOf(".ttf") > -1 || path.indexOf(".css") > -1 || path.indexOf(".js") > -1
        		|| path.indexOf(".png") > -1 || path.indexOf(".jpg") > -1 || path.indexOf("/login.do") > -1 || path.indexOf(".html") > -1
        		|| path.indexOf("/cugbResearchers.do") > -1|| path.indexOf("/cugbFunds.do") > -1|| path.indexOf("/cugbPapers.do") > -1
        		|| path.indexOf("/fmzlSta.do") > -1|| path.indexOf("/pingtaiList.do") > -1|| path.indexOf("/huojiangList.do") > -1
        		|| path.indexOf("/kyxm/fund.do") > -1|| path.indexOf("/kyxm/nstProject.do") > -1|| path.indexOf("/kyxm/yxdb.do") > -1
        		|| path.indexOf("/xslw/sjlw.do") > -1|| path.indexOf("/xslw/yxdb.do") > -1|| path.indexOf("/xslw/paperList.do") > -1
        		|| path.indexOf("/kyxm/fundList.do") > -1|| path.indexOf("/kjcQuery.do") > -1|| path.indexOf("/kjcQueryList.do") > -1|| path.indexOf("/cugb.do") > -1
                || path.indexOf("/fmzl/zhzl.do") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 判断如果没有取到用户信息,就跳转到登陆页面
        if (username == null || "".equals(username)) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/kjcManager/cugb.do");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
