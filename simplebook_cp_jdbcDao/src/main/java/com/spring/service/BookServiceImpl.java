package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.persistence.BookDAO;

@Service("book")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO dao;
	
	@Override
	public List<BookVO> getList() {
		return dao.getList();
	}

	@Override
	public int insertBook(BookVO vo) {
		return dao.insertBook(vo);
	}

	@Override
	public int updateBook(BookVO vo) {
		return dao.updateBook(vo.getPrice(), vo.getCode());
	}

	@Override
	public int deleteBook(String code) {
		return dao.deleteBook(code);
	}

	@Override
	public BookVO getBook(String code) {
		return dao.getBook(code);
	}

}
