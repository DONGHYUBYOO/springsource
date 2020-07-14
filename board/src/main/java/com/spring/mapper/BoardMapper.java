package com.spring.mapper;

import java.util.List;

import com.spring.domain.ArticleVO;
import com.spring.domain.CriteriaVO;
import com.spring.domain.ModifyVO;
import com.spring.domain.ReadVO;
import com.spring.domain.RegistVO;

public interface BoardMapper {
	public List<ArticleVO> listArticle(CriteriaVO criteria);
	public int totalArticle(CriteriaVO criteria);
	public int insertArticle(RegistVO regist);
	public ReadVO getArticle(int bno);
	public int modifyArticle(ModifyVO modify);
	public int removeArticle(int bno);
}
