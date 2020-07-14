package com.spring.domain;

import lombok.Data;

@Data
public class PageVO {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int total;
	private CriteriaVO criteria;
	
	public PageVO(CriteriaVO criteria, int total) {
		this.criteria=criteria;
		this.total=total;
		
		//끝나는 페이지 계산
		endPage=(int)(Math.ceil(criteria.getPageNum()/10.0))*10;
		//시작 페이지 계산
		startPage=this.endPage-9;
		
		//끝나는 페이지가 10이 아닐 경우 실제 페이지 구하기
		int realEnd=(int)(Math.ceil((total/1.0)/criteria.getAmount()));
		if(realEnd<this.endPage) {
			endPage=realEnd;
		}
		this.prev=startPage>1;
		this.next=endPage<realEnd;
	}
}
