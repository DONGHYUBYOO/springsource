package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
				
		Product p=(Product)ctx.getBean("product");
		p.setCompany("LEGO");
		p.setPname("LEGO 블럭");
		p.setPrice(100000);
		p.getInfo();		
	}
}
