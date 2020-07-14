package com.spring.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.AuthVO;
import com.spring.domain.ChangeVO;
import com.spring.domain.LoginVO;

public interface MemberMapper {
	public AuthVO isLogin(LoginVO login);
	public String checkPWD(ChangeVO change);
	//public int changePWD(@Param("userid") String userid, @Param("confirm_password") String confirm_password);
	public int changePWD(ChangeVO change);
	public int leave(@Param("userid") String userid, @Param("password") String password);
}
