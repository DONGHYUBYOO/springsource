package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;

@Service("book")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper mapper;

	@Override
	public boolean insert(BookVO vo) {
		return mapper.insertBook(vo)==0?false:true;
	}
	@Override
	public boolean update(BookVO vo) {
		return mapper.updateBook(vo)==0?false:true;
	}
	@Override
	public boolean delete(String code) {
		return mapper.deleteBook(code)==0?false:true;
	}
	@Override
	public BookVO getBook(String code) {
		return mapper.getBook(code);
	}
	@Override
	public List<BookVO> getList() {
		return mapper.listBook();
	}
}
