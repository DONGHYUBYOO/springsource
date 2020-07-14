package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	//게시판과 관련된 기능 등록
	public int insertBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(BoardVO vo);
	public BoardVO getBoard(int bno);
	public List<BoardVO> getList();	
}
