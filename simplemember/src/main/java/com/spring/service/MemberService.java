package com.spring.service;

import java.util.List;

import com.spring.domain.MemberVO;

public interface MemberService {
	public MemberVO isLogin(String userid, String password);
	public int joinMember(MemberVO vo);
	public int updateMember(String userid, String new_password, String current_password);
	public int leaveMember(String userid, String password);	
	public List<MemberVO> getList();
}
