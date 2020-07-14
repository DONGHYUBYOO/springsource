package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RedirectController {
	@GetMapping("/doA")	
	public String doA(RedirectAttributes rttr) {
		log.info("doA 요청");
		
		//RedirectAttributes : 일회성으로 값을 전달하기 위한 용도
		//파라미터 형식으로 보내기
		//path+="?age=10"
		rttr.addAttribute("age", 10);
		
		return "redirect:/member/login";	//http:localhost:8080	=> /(root)로 이동시킨 상태 => url을 새롭게 생성 
	}
	
	@GetMapping("/doB")
	public String doB(RedirectAttributes rttr) {
		log.info("doB 요청");
		
		//세션객체에 담아줌
		//잠시 세션에 담았다가 세션에서 삭제
		rttr.addFlashAttribute("age", 10);
		
		return "redirect:/";
	}
}
