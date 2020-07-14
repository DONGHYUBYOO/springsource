package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	//게시판과 관련된 기능 등록
	int insertArticle(BoardVO vo);
	int updateArticle(BoardVO vo);
	int deleteArticle(BoardVO vo);
	BoardVO getArticle(int bno);
	List<BoardVO> getList();	
}
