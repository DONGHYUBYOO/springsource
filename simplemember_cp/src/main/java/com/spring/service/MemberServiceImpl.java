package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.MemberVO;
import com.spring.persistence.MemberDAO;

@Service("member")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public MemberVO isLogin(String userid, String password) {
		return null;
	}
	@Override
	public int joinMember(MemberVO vo) {
		return 0;
	}
	@Override
	public int updateMember(String userid, String new_password, String current_password) {
		return 0;
	}
	@Override
	public int leaveMember(String userid, String password) {
		return 0;
	}	
	@Override
	public List<MemberVO> getList() {
		return dao.getList();
	}
}
