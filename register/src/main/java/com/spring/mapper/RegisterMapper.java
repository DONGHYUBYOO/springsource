package com.spring.mapper;

import com.spring.domain.RegisterVO;

public interface RegisterMapper {
	public int regist(RegisterVO vo);
	public RegisterVO checkID(String userid);
}
