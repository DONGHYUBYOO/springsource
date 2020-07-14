package com.spring.factorial;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactorialMain {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Calculator cal=(Calculator)ctx.getBean("for");
		System.out.println("반복문(for) : "+cal.factorial(10));
		System.out.println("=====================");
		cal=(Calculator)ctx.getBean("rec");
		System.out.println("재귀함수 : "+cal.factorial(10));
	}
}
