package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	//도서목록보기
	public List<BookVO> listBook();	
	//도서정보입력
	public int insertBook(BookVO book);	
	//도서정보수정
	public int updateBook(String code, int price);	
	//도서정보삭제
	public int deleteBook(String code);	
	//도서정보검색
	public List<BookVO> getBook(String criteria, String keyword);
}
