package com.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungSpeaker implements Speaker {
	public SamsungSpeaker() {
		System.out.println("삼성스피커() 객체 생성");
	}
	@Override
	public void volumeUp() {
		System.out.println("삼성스피커 -- 소리 올리기");		
	}
	@Override
	public void volumeDown() {
		System.out.println("삼성스피커 -- 소리 내리기");		
	}
}
