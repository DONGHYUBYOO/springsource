package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.ArticleVO;
import com.spring.domain.CriteriaVO;
import com.spring.domain.ModifyVO;
import com.spring.domain.ReadVO;
import com.spring.domain.RegistVO;
import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	public List<ArticleVO> listArticle(CriteriaVO criteria) {
		return mapper.listArticle(criteria);
	}

	@Override
	public int insertArticle(RegistVO regist) {
		return mapper.insertArticle(regist);
	}

	@Override
	public ReadVO getArticle(int bno) {
		return mapper.getArticle(bno);
	}

	@Override
	public int modifyArticle(ModifyVO modify) {
		return mapper.modifyArticle(modify);
	}

	@Override
	public int removeArticle(int bno) {
		return mapper.removeArticle(bno);
	}

	@Override
	public int totalArticle(CriteriaVO criteria) {
		return mapper.totalArticle(criteria);
	}	
}
