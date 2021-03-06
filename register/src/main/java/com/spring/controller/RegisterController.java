package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.RegisterVO;
import com.spring.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private RegisterService service;
	
	@GetMapping("/step2")
	public void step2Get() {
		log.info("step2 Form 요청");		
	}
	
//	@PostMapping("/step2")
//	public String handleStep2(boolean agree, RedirectAttributes rttr) {
//		log.info("step2 Form 요청"+agree);
//		//agree 체크 확인
//		if(!agree) {
//			rttr.addFlashAttribute("msg", "false");
//			return "redirect:step1";
//		}
//		return "/register/step2";
//	}
//	
//	@PostMapping("/step3")
//	public String step3(@ModelAttribute("register") RegisterVO register) {
//		//step2.jsp에서 사용자의 입력값 가져오기		
//		log.info("step2 요청 : "+register);
//		
//		log.info("아이디 : "+register.getUserid());
//		log.info("비밀번호 : "+register.getPassword());
//		log.info("비밀번호 확인 : "+register.getConfirm_password());
//		log.info("이름 : "+register.getName());
//		log.info("성별 : "+register.getGender());
//		log.info("이메일 : "+register.getEmail());
//		
//		if(register.isPasswordEqualToConfirmPassword()) {			
//			if(service.regist(register)) {
//				log.info("회원가입 성공");
//				return "/register/step3";				
//			}
//		}
//		
////		if(register.isPasswordEqualToConfirmPassword()) {
////			return "/register/step3";			
////		}else {
////			return "/register/step2";			
////		}		
//		return "/register/step2";			
//	}
//	
//	@GetMapping(value= {"/step2", "/step3"})
//	public String handleStep2_3() {
//		//사용자가 step2, step3를 get 방식으로 요청하는 경우
//		//step1으로 돌려보내기
//		
//		return "redirect:/register/step1";
//	}
//	
//	@PostMapping("checkId")
//	@ResponseBody	//컨트롤러에서 던지는 값이 jsp가 아님을 의미
//	public String checkId(String userid) {
//		log.info("중복 아이디 검사 : "+userid);
//		
//		RegisterVO vo=service.checkID(userid);
//		if(vo.getUserid().isEmpty()) {
//			return "true";
//		}else {
//			return "false";
//		}
//	}
}
