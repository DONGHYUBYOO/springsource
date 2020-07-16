package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.CriteriaVO;
import com.spring.domain.ReplyPageVO;
import com.spring.domain.ReplyVO;
import com.spring.mapper.BoardMapper;
import com.spring.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int insertReply(ReplyVO reply) {
		//댓글 게시물 수 변경
		boardMapper.updateReplyCnt(reply.getBno(), 1);
		//댓글 삽입
		return replyMapper.insertReply(reply);
	}

	@Override
	public ReplyVO getReply(int rno) {
		return replyMapper.getReply(rno);
	}

	@Override
	public int modifyReply(ReplyVO reply) {
		return replyMapper.modifyReply(reply);
	}

	@Transactional
	@Override
	public int deleteReply(int rno) {
		//rno를 이용해 bno 알아내기
		ReplyVO vo=replyMapper.getReply(rno);
		//댓글 게시물 수 변경
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		//댓글 삭제
		return replyMapper.deleteReply(rno);
	}

	@Override
	public ReplyPageVO listReply(CriteriaVO criteria, int bno) {
		return new ReplyPageVO(replyMapper.totalReply(bno), replyMapper.listReply(criteria, bno));
	}

	@Override
	public int getCountByBno(int bno) {
		return replyMapper.totalReply(bno);
	}
}
