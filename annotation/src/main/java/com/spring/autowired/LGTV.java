package com.spring.autowired;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LGTV implements TV {	
	//@Autowired
	@Inject
	@Qualifier("samsung")
	private Speaker speaker;
	
	public LGTV() {
		super();
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
