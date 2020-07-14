package com.spring.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.domain.BookVO;

public class BookRowMapper implements RowMapper<BookVO> {

	@Override
	public BookVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookVO vo = new BookVO();
		vo.setCode(rs.getString("code"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setPrice(rs.getInt("price"));
		return vo;
	}

}
