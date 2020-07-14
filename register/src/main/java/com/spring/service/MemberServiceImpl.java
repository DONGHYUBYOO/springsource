package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.AuthVO;
import com.spring.domain.ChangeVO;
import com.spring.domain.LoginVO;
import com.spring.mapper.MemberMapper;

@Service("member")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public AuthVO isLogin(LoginVO login) {
		return mapper.isLogin(login);
	}
	@Override
	public String checkPWD(ChangeVO change) {
		return mapper.checkPWD(change);
	}
	@Override
	public int changePWD(ChangeVO change) {
		return mapper.changePWD(change);
	}
	@Override
	public int leave(String userid, String password) {
		return mapper.leave(userid, password);
	}	
}
