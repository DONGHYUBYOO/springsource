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
		return dao.isLogin(userid, password);
	}
	@Override
	public int joinMember(MemberVO vo) {
		return dao.joinMember(vo);
	}
	@Override
	public int updateMember(String userid, String new_password, String current_password) {
		return dao.updateMember(userid, current_password, new_password);
	}
	@Override
	public int leaveMember(String userid, String password) {
		return dao.leaveMember(userid, password);
	}	
	@Override
	public List<MemberVO> getList() {
		return dao.getList();
	}
}
