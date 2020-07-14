package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.RegisterVO;
import com.spring.mapper.RegisterMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("register")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterMapper mapper;
	
	@Override
	public boolean regist(RegisterVO vo) {
		log.info("회원가입 서비스 호출");
		return mapper.regist(vo)==0 ? false : true;
	}

	@Override
	public RegisterVO checkID(String userid) {
		return mapper.checkID(userid);
	}	
}
