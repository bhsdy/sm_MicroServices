package com.sm.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter(urlPatterns={"/api/auth/*"}, filterName="tokenAuthorFilter")
public class TokenAuthorFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(TokenAuthorFilter.class);
	
	@Override
	public void destroy() {
 
	}
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		logger.info("==> doFilter开始过滤请求...");
		String token = req.getHeader("token");
		
		
		
		
		
		
		boolean isFilter = true;
		if(isFilter){
			logger.info("==> doFilter验证通过.");
			chain.doFilter(request, response);
		}
	}
 
	@Override
	public void init(FilterConfig arg0) throws ServletException {
 
	}


 
}
