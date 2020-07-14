package com.spring.service;

import java.util.List;

import com.spring.domain.CriteriaVO;
import com.spring.domain.ReplyVO;

//변수명, 메서드명 규칙 (카멜케이스)
//소문자로 시작
//두 단어가 연결되었을 때 두번째 단어의 첫 시작부분을 대문자로 주기

//데이터베이스 규칙(스네이크케이스)
//reply_service / reply_insert

public interface ReplyService {
	public int insertReply(ReplyVO reply);
	public ReplyVO getReply(int rno);
	public int modifyReply(ReplyVO reply);
	public int deleteReply(int rno);
	public List<ReplyVO> listReply(CriteriaVO criteria, int bno);
	public int getCountByBno(int bno);
}
