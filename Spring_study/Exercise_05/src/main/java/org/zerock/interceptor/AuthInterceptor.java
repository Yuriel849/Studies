package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//																			  "Object handler" -> 지금 실행하려는 메서드 그 자체를 지칭!
		
		HttpSession session = request.getSession();
		
		// 사용자가 로그인한 상태가 아니라면 (세션에 로그인 속성이 없다면) 로그인하도록 login페이지로 이동
		if(session.getAttribute("login") == null) {
			logger.info("current user is not logged in");
			saveDest(request);
			response.sendRedirect("/user/login");
			return false;
		}
		
		return true;
	}
	
	private void saveDest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		
		if(query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		
		if(request.getMethod().equals("GET")) {
			logger.info("dest: " + (uri+query));
			request.getSession().setAttribute("dest", uri + query);
		}
	}
}