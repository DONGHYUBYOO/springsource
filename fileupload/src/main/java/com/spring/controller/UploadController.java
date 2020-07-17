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
	
	//다운로드 컨트롤러
	//produces : 보내는 파일에 대한 타입 (APPLICATION_OCTET_STREAM_VALUE => 2진타입으로 변환하여 대부분의 파일을 호환)
	@GetMapping(value="/download", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName) {
		log.info("다운로드 파일 : "+fileName);
		
		Resource resource = new FileSystemResource("d:\\JAVA_Upload\\"+fileName);
		
		String resourName=resource.getFilename();
		
		//브라우저 헤더에 붙여 보내기
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition", "attachment;fileName="
					+new String(resourName.getBytes("utf-8"), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
