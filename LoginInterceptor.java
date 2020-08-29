package kr.ac.hanalife.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.hanalife.member.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod method = (HandlerMethod)handler;
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		MemberVO loginVO = (MemberVO)session.getAttribute("loginVO");
		
		if(loginVO == null) {
			
			String uri = request.getRequestURI();
			uri = uri.substring(request.getContextPath().length());
			
			String query = request.getQueryString();
			
			if(query != null && query.length() != 0)
				uri = uri + "?" + query;
			session.setAttribute("dest", uri);
			
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		
		return true;
	}
	
	
}
