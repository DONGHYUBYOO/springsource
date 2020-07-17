package com.spring.domain;

import lombok.Data;

@Data
public class AttachFileVO {
	private String uuid;	//uuid
	private String uploadPath;	//날짜별 폴더 생성 후 파일 저장을 위해
	private String fileName;	//파일명
	private boolean fileType;	//이미지 여부 확인
}
