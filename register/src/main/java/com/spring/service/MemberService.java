package com.spring.service;

import com.spring.domain.AuthVO;
import com.spring.domain.ChangeVO;
import com.spring.domain.LoginVO;

public interface MemberService {
	public AuthVO isLogin(LoginVO login);
	public String checkPWD(ChangeVO change);
	public int changePWD(ChangeVO change);
	public int leave(String userid, String password);
}
