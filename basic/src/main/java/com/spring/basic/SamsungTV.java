package com.spring.basic;

public class SamsungTV implements TV {
	private Speaker speaker;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	@Override
	public void powerOn() {
		System.out.println("삼성-TV : 전원 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성-TV : 전원 OFF");
	}
	@Override
	public void volumeUp() {
		//speaker.volumeUp();
		System.out.println("삼성-TV : 볼륨 UP");
	}
	@Override
	public void volumeDown() {
		//speaker.volumeDown();
		System.out.println("삼성-TV : 볼륨 DOWN");
	}
}
