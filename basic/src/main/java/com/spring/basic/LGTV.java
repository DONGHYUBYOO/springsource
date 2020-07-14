package com.spring.basic;

public class LGTV implements TV {
	private Speaker speaker;
	
	public LGTV() {
		super();
	}
	public LGTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("LG-TV : 전원 ON");	
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
