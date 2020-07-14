package com.spring.domain;

import lombok.Data;

@Data
public class CriteriaVO {
	private int pageNum;	//페이지번호
	private int amount;		//한페이지당 보여줄 게시물 수
		
	private String type;	//검색조건
	private String keyword;	//검색어
	
	
	public CriteriaVO() {
		this(1,10);
	}
	public CriteriaVO(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public String[] getTypeArr() {
		return type==null?new String[] {}:type.split("");
	}
}
