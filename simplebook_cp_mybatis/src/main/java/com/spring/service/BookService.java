package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	public boolean insert(BookVO vo);
	public boolean update(BookVO vo);
	public boolean delete(String code);
	public BookVO getBook(String code);	
	public List<BookVO> getList();
}
