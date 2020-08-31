package kr.ac.hanalife.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod method = (HandlerMethod)handler;
		
		//�α��� ���� üũ
		HttpSession session = request.getSession();
		MemberVO loginVO = (MemberVO)session.getAttribute("loginVO");
		EmployeeVO employee = (EmployeeVO)session.getAttribute("employee");
		
		if(loginVO == null || employee == null ) {
			
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
