package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.PartnerVO;
import com.spring.service.PartnerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller	//객체 생성
public class PartnerController {
	
	
	@Autowired	//객체 주입
	private PartnerService service;
	
	@GetMapping("/partner/register")
	public void registerGet() {
		log.info("파트너 입력 폼 요청");		
	}
	
	//String : String으로 리턴된 값 (예를 들어 test라 할 때) 
		//보여지는 페이지와 주소가 다른 경우 => Forward
			//페이지값 :  
			//redirect : 주소를 새롭게 작성
				//localhost:8080/ 형태로 이동하기 때문에 해당 주소를 갖는 Controller가 존재 해야 한다. 
	//void : 요청 주소 뒤에 .jsp 만 붙여서 페이지를 찾게 됨 => localhost:8080/view/test.jsp 
	@PostMapping("/partner/register")
	public String registerPost(PartnerVO partner) {
		log.info("파트너 정보 입력 요청");
		log.info(""+partner);
		service.create(partner);
//		return "/exam/test";		
		return "redirect:list";
		//redirect:list => http://localhost:8080/partner/list
		//redirect:/list => http://localhost:8080/list
	}
	
	@GetMapping("/partner/list")
	public void list(Model model) {
		log.info("/partner/list.jsp 화면 요청");
		List<PartnerVO> list=service.list();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/exam/test")
	public void test() {
		log.info("/exam/test.jsp 화면 요청");
	}
}
