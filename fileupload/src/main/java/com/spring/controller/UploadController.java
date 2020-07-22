package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("uploadForm.jsp 화면 요청");
	}
	
	@PostMapping("/uploadForm")
	public void upload(MultipartFile[] uploadFile) {
		log.info("upload 요청");
		String uploadPath="d:\\JAVA_Upload";
		for(MultipartFile f:uploadFile) {
			log.info("============================");
			log.info("Upload File Name"+f.getOriginalFilename());		
			log.info("Upload File Size"+f.getSize());
			
			//서버 폴더에 파일 저장(File or Path 객체로 저장)
			File saveFile = new File(uploadPath, f.getOriginalFilename());
			try {
				f.transferTo(saveFile);	//서버 폴더에 파일 저장
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
