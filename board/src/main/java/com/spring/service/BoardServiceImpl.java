package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.ArticleVO;
import com.spring.domain.AttachFileVO;
import com.spring.domain.CriteriaVO;
import com.spring.domain.ModifyVO;
import com.spring.domain.ReadVO;
import com.spring.domain.RegistVO;
import com.spring.mapper.AttachMapper;
import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper board;
	
	@Autowired
	private AttachMapper attach;

	@Override
	public List<ArticleVO> listArticle(CriteriaVO criteria) {
		return board.listArticle(criteria);
	}

	@Transactional
	@Override
	public int insertArticle(RegistVO regist) {
		//게시글 DB 저장
		int result=board.insertArticle(regist);
		
		//첨부파일 DB에 저장
		//bno정보가 초기에 없기 때문에 게시글을 DB에 저장 후 첨부파일 정보 저장
		if(regist.getAttachList() == null || regist.getAttachList().size() <= 0) {
			return result;
		}
		regist.getAttachList().forEach(attach1 -> {
			attach1.setBno(regist.getBno());
			attach.insertAttach(attach1);
		});
		return 1;
	}

	@Override
	public ReadVO getArticle(int bno) {
		ReadVO read = board.getArticle(bno);
		read.setAttachList(attach.searchAttach(bno));
		return read;
	}

	@Override
	public int modifyArticle(ModifyVO modify) {
		//현재 bno의 게시물 DB에서 삭제
		attach.deleteAttach(modify.getBno());		
		//첨부파일 삽입
		if(modify.getAttachList() != null && modify.getAttachList().size() >=0) {
			for(AttachFileVO vo:modify.getAttachList()) {
				vo.setBno(modify.getBno());
				attach.insertAttach(vo);				
			}
		}
		return board.modifyArticle(modify);
	}
	
	@Transactional
	@Override
	public int removeArticle(int bno) {
		attach.deleteAttach(bno);
		return board.removeArticle(bno);
	}

	@Override
	public int totalArticle(CriteriaVO criteria) {
		return board.totalArticle(criteria);
	}

	@Override
	public List<AttachFileVO> searchAttach(int bno) {
		return attach.searchAttach(bno);
	}	
}
