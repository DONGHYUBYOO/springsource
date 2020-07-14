package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BookVO;

public interface BookMapper {
	public List<BookVO> listBook();
	public int insertBook(BookVO book);
	public int updateBook(@Param("code") String code, @Param("price")int price);
	public int deleteBook(String code);
	public List<BookVO> getBook(@Param("criteria") String criteria, @Param("keyword") String keyword);
}
