package com.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.SampleService;

public class SampleClient {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		SampleService sample=(SampleService)ctx.getBean("sample");
		
		String data="동해물과백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세"
				+"남산 위에 저 소나무 철갑을 두른듯 바람서리 불며함은 우리 기상일세"
				+"가을 하늘 공활한데 높고 구름 없이 외로우나 즐거우나 나라 사랑하세";
		sample.addData(data);
	}
}
