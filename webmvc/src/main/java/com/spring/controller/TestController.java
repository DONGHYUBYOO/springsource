package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	@RequestMapping("/test")
	public void test() {
		log.info("test 요청...");
	}
	@RequestMapping("/login")
	public void test2() {
		log.info("test2 요청...");
	}
	@RequestMapping("/test3")
	public String test3() {
		log.info("test3 요청...");
		return "test3";
	}
	@RequestMapping("/sample/test4")
	public void test4() {
		log.info("test4 요청...");
	}
	
}
