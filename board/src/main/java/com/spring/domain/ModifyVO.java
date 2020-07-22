package com.spring.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	
	//게시글 등록시 첨부파일 목록
	private List<AttachFileVO> attachList;
}
