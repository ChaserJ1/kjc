package com.webscience.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex);
		// 根据不同错误转向不同页面
		if (ex instanceof NullPointerException) {
			logger.error("error occures.....", ex);
			model.put("msg", ex.getMessage());
			return new ModelAndView("forward:/common/fail.jsp", model);
		}else if(ex instanceof InvalidDataAccessResourceUsageException){
			logger.error("error occures.....", ex);
			model.put("msg", "用户权限不足，请先配置有权限的数据库账户");
			return new ModelAndView("forward:/common/fail.jsp", model);
		} else if (ex instanceof RuntimeException) {
			logger.error("error occures.....", ex);
			model.put("msg", ex.getMessage());
			return new ModelAndView("forward:/common/fail.jsp", model);
			
		} else {
			logger.error("error occures.....", ex);
			model.put("msg", "发生错误");
			return new ModelAndView("forward:/common/fail.jsp", model);
		}
	}
}