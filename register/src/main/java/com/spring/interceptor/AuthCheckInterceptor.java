package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.domain.AuthVO;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("비밀번호 변경 - Pre Handler");
		
		//auth 세션 존재 확인 후 
		//changePWD 작업을 진행할 수 있도록 해주고
		//세션값이 없다면 로그인 페이지로 돌려보내기
		HttpSession session=request.getSession(false);
		session.getAttribute("auth");
		if(session != null) {
			AuthVO auth=(AuthVO)session.getAttribute("auth");
			if(auth != null) {
				return true;				
			}
		}
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
	}	
}
