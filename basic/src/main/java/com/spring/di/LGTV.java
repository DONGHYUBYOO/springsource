package com.spring.di;

public class LGTV implements TV {
	private Speaker speaker;
	private int price;
	
	public LGTV() {
		super();
	}
	public LGTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}
	public LGTV(Speaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("LG-TV : 전원 ON");	
		System.out.println("스피커 가격 : "+price);	
	}
	@Override
	public void powerOff() {
		System.out.println("LG-TV : 전원 OFF");		
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
		//System.out.println("LG-TV : 볼륨 UP");		
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("LG-TV : 볼륨 DOWN");		
	}
}
