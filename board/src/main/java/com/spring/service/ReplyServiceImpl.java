package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.CriteriaVO;
import com.spring.domain.ReplyVO;
import com.spring.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public int insertReply(ReplyVO reply) {
		return mapper.insertReply(reply);
	}

	@Override
	public ReplyVO getReply(int rno) {
		return mapper.getReply(rno);
	}

	@Override
	public int modifyReply(ReplyVO reply) {
		return mapper.modifyReply(reply);
	}

	@Override
	public int deleteReply(int rno) {
		return mapper.deleteReply(rno);
	}

	@Override
	public List<ReplyVO> listReply(CriteriaVO criteria, int bno) {
		return mapper.listReply(criteria, bno);
	}

	@Override
	public int getCountByBno(int bno) {
		return mapper.totalReply(bno);
	}

}
