package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	public List<BookVO> getList();
	public int insertBook(BookVO vo);
	public int updateBook(BookVO vo);
	public int deleteBook(String code);
	public BookVO getBook(String code);	
}
