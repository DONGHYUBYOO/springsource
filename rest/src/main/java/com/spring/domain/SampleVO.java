package com.spring.domain;

public class SampleVO {
	private String mno;
	private String firstName;
	private String lastName;	
	
	public SampleVO() {
		
	}
	
	public SampleVO(String mno, String firstName, String lastName) {
		this.mno=mno;
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}



