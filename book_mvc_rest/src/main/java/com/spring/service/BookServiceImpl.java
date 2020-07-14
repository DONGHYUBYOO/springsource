package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper mapper;
	
	@Override
	public BookVO infoBook(String code) {
		return mapper.infoBook(code);
	}
	
	@Override
	public List<BookVO> listBook() {
		return mapper.listBook();
	}

	@Override
	public int insertBook(BookVO book) {
		return  mapper.insertBook(book);
	}

	@Override
	public int updateBook(String code, int price) {
		return mapper.updateBook(code, price);
	}

	@Override
	public int deleteBook(String code) {
		return mapper.deleteBook(code);
	}

	@Override
	public List<BookVO> getBook(String criteria, String keyword) {
		return mapper.getBook(criteria, keyword);
	}

}
