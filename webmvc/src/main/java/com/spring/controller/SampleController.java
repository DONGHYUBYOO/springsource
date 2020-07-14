package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("sample")
public class SampleController {
	//컨트롤러 안에 작성한 메서드와 @RequestMapping을 연결하면
	//사용자의 요구에 응답하는 처리를 만들어 낼 수 있음
	
	@RequestMapping("/basic")	//연결주소
	public void basic() {
		log.info("basic 요청...");	//연결파일 .jsp
	}
	@RequestMapping("/test")
	public void test() {
		log.info("test 요청...");
	}
	@RequestMapping("/login")
	public String login() {
		log.info("login 요청...");
		return "signin";
	}
}
