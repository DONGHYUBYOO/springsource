package com.spring.di;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("소니스피커() 객체 생성");
	}
	@Override
	public void volumeUp() {
		System.out.println("소니스피커 -- 소리 올리기");		
	}
	@Override
	public void volumeDown() {
		System.out.println("소니스피커 -- 소리 내리기");		
	}
}
