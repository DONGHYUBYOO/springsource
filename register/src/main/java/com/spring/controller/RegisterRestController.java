package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.RegisterVO;
import com.spring.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/register")
public class RegisterRestController {

	@Autowired
	private RegisterService service;
	
	//http://localhost:8080/register/step2 =>
	//http://localhost:8080/register/insert + post =>
//	@PostMapping("/insert")
//	public ResponseEntity<String> registerPost(@RequestBody RegisterVO register) {
//		log.info("회원가입 : "+register);
//		return service.regist(register)
//				? new ResponseEntity<String>("success", HttpStatus.OK)
//						: new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
//	}
	@PostMapping("/insert")
	public ResponseEntity<String> registerPost(RegisterVO register) {
		log.info("회원가입 : "+register);
		return service.regist(register)
				? new ResponseEntity<String>("success", HttpStatus.OK)
						: new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
}
