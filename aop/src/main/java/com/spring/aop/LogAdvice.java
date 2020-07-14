package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component("log")
public class LogAdvice {
	public void beforeLog() {
		System.out.println("[공통로그] 비지니스 로직 수행 前 호출");
	}
	public void afterLog() {
		System.out.println("[공통로그] 비지니스 로직 수행 後 호출");
	}
	public void afterReturnLog() {
		System.out.println("[공통로그] 비지니스 로직 정상수행 後 호출");
	}
	public void afterThrowLog() {
		System.out.println("[공통로그] 비지니스 로직 Exception발생 後 호출");
	}
	public void aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[공통로그] 비지니스 로직 수행 前-後 호출");
		
		System.out.println("[공통로그] 비지니스 로직 수행 前 호출");		
		try {
			//실제 수행할 비즈니스 메서드 호출
			pjp.proceed();	
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("[공통로그] 비지니스 로직 수행 後 호출");
	}	
}
