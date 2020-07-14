package com.spring.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.domain.MemberVO;

public class MemberRowMapper implements RowMapper<MemberVO> {

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO vo = new MemberVO();
		vo.setUserid(rs.getString("userid"));
		vo.setPassword(rs.getString("password"));
		vo.setName(rs.getString("name"));
		vo.setGender(rs.getString("gender"));
		vo.setEmail(rs.getString("email"));
		return vo;
	}

}
