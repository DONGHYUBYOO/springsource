package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.CriteriaVO;
import com.spring.domain.ReplyVO;

public interface ReplyMapper {
	public int insertReply(ReplyVO reply);
	public ReplyVO getReply(int rno);
	public int modifyReply(ReplyVO reply);
	public int deleteReply(int rno);
	public List<ReplyVO> listReply(@Param("criteria") CriteriaVO criteria, @Param("bno") int bno);
	public int totalReply(int bno);
}
