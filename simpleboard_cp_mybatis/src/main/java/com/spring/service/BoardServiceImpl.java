package com.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.mapper.BoardMapper;

@Service("board")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public int insertBoard(BoardVO vo) {		
		return mapper.insertBoard(vo);
	}
	@Override
	public int updateBoard(BoardVO vo) {
		return mapper.updateBoard(vo);
	}
	@Override
	public int deleteBoard(BoardVO vo) {
		return mapper.deleteBoard(vo);
	}
	@Override
	public BoardVO getBoard(int bno) {
		return mapper.getBoard(bno);
	}
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}
}
