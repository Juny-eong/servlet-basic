package com.coderby.myapp.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		try {
			HttpSession session = request.getSession();
			String contextName = request.getContextPath();
			String url = request.getRequestURI().replaceFirst(contextName, "");
			
			String param = request.getQueryString();
			
			if (!url.contains("/user/login") && !url.contains("/user/logout")) {
				session.setAttribute("url", url);
				session.setAttribute("param", param);
			}
			else {
				// nothing
			}
			
			String userId = (String) request.getSession().getAttribute("userId");
			if (userId == null || "".equals(userId)) {
				response.sendRedirect(request.getContextPath() + "/user/login");
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
