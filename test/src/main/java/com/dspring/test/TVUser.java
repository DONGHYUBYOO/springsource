package com.dspring.test;

public class TVUser {
	public static void main(String[] args) {
		TV lg = new LGTV(new SonySpeaker());		
		lg.powerOn();
		lg.volumeUp();
		lg.volumeDown();
		lg.powerOff();		
		
		System.out.println();
		
		SamsungTV samsung = new SamsungTV();
		samsung.setSpeaker(new SonySpeaker());
		samsung.powerOn();
		samsung.volumeUp();
		samsung.volumeDown();
		samsung.powerOff();	
	}
}
