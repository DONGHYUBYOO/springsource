package com.spring.di;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public void powerOn() {
		System.out.println("삼성-TV : 전원 ON");
		System.out.println("스피커 가격 : "+price);	
	}
	@Override
	public void powerOff() {
		System.out.println("삼성-TV : 전원 OFF");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
		//System.out.println("삼성-TV : 볼륨 UP");
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("삼성-TV : 볼륨 DOWN");
	}
}
