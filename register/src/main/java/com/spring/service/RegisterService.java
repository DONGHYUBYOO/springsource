package com.spring.service;

import com.spring.domain.RegisterVO;


public interface RegisterService {
	public boolean regist(RegisterVO vo);
	public RegisterVO checkID(String userid);
}
