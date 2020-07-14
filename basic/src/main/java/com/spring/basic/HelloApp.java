package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		MessageBean msg=(MessageBean)ctx.getBean("msg");
		
		msg.sayHello("박유성모마리아");
	}
}
