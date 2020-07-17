package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.domain.AttachFileVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AjaxUploadController {
	
	@GetMapping("/uploadAjax")
	public void uploadAjaxForm() {
		log.info("/uploadAjax.jsp 화면 요청");
	}	
	@PostMapping(value="/uploadAjax", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileVO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		log.info("uploadAjax 요청");
		
		String uploadFolder="D:\\JAVA_Upload";
		String uploadFileName="";
		
		String uploadFolderPath=makeFolder();
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		if(!uploadPath.exists()) {	//폴더가 존재하지 않으면
			uploadPath.mkdirs();	//년-월-일 값으로 폴더 생성
		}
		
		List<AttachFileVO> attachList = new ArrayList<>();
		
		for(MultipartFile f:uploadFile) {
			log.info("==============");
			log.info("upload File Name : "+f.getOriginalFilename());
			log.info("upload File Size : "+f.getSize());
			
			//파일의 중복을 제거하기 위해 고유값 설정
			UUID uuid=UUID.randomUUID();			
			uploadFileName=uuid.toString()+"_"+f.getOriginalFilename();
			
			AttachFileVO attach = new AttachFileVO();
			attach.setFileName(f.getOriginalFilename());
			attach.setUploadPath(uploadFolderPath);
			attach.setUuid(uuid.toString());
			
			try {
				Path saveFile=Paths.get(uploadPath.getPath(), uploadFileName);
				f.transferTo(saveFile);

				//이미지 파일 여부 확인
				if(checkImageType(saveFile.toFile())) {
					attach.setFileType(true);
				}		
				attachList.add(attach);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}			
		}		
		//ok 상태코드와 + uuid가 붙은 파일명 리턴
		return new ResponseEntity<List<AttachFileVO>>(attachList, HttpStatus.OK);
	}	
	
	//이미지 파일 여부 확인 메서드
	private boolean checkImageType(File file) {
		String contentType;
		try {
			contentType=Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//날짜별 폴더 생성 메서드
	private String makeFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		Date date = new Date();
		
		String str=sdf.format(date);
		return str.replace("-",  File.separator);
	}	
}
