package com.spring.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		System.out.println("IoC 컨테이너 구동 전");
		
		//스프링 컨테이너 구동하기 => 설정파일 읽기
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config3.xml");
		System.out.println("컨테이너 구동 후");
		
		//Look Up : 스프링 컨테이너로부터 필요한 객체를 요청
		//@Component로 객체 생성시 규칙
		//클래스 이름의 첫 문자를 소문자로 바꾼 후 객체가 생성
		TV tv = (TV)ctx.getBean("LGTV");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
