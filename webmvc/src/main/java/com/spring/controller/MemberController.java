package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.LoginVO;
import com.spring.domain.RegisterVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	//default가 get방식 이기 때문에 post로 전송할 경우 반드시 명시 해야 한다.
	//@RequestMapping(value="/login", method=RequestMethod.POST)	//정식 방법
	//@GetMapping("/login")	//4.3버전 이후의 편의 방법
	//@PostMapping("/login")
	//@PutMapping("/login")	//==	@PatchMapping("/login") put과 동일
	//@DeleteMapping("/login")
	@GetMapping("/login")
	public void login() {
		log.info("login Form 요청");
	}
	
	//같은 주소를 사용하지만 mapping 방식이(get, post, put, delete) 달라지면 동일시 되지 않는다.
//	@PostMapping("/login")
//	public void loginPost(String userid, String password) {	//변수명이 동일해야 자동 mapping을 통해 가져올 수 있다.
//		log.info("login 요청");
//		
//		//사용자가 보낸 값 가져오기
//		log.info("아이디 : "+userid);
//		log.info("비밀번호 : "+password);
//	}
	
//	@PostMapping("/login")
//	//변수명을 다르게 사용할 경우 또는 의미를 명확하게 구분하기 위해
//	public void loginPost(@RequestParam("userid") String id, @RequestParam("password") String pwd) {	
//		log.info("login 요청");
//		
//		//사용자가 보낸 값 가져오기
//		log.info("아이디 : "+id);
//		log.info("비밀번호 : "+pwd);
//	}
	
	@PostMapping("/login")
	//변수명을 다르게 사용할 경우 또는 의미를 명확하게 구분하기 위해
	public String loginPost(LoginVO login) {	
		log.info("login 요청");
		
		//사용자가 보낸 값 가져오기
		log.info("아이디 : "+login.getUserid());
		log.info("비밀번호 : "+login.getPassword());
		
		//logout.jsp 보여주기
		return "member/logout";
	}
	
	@RequestMapping("/logout")
	public void logout() {
		log.info("logout() 요청...");
	}
	@GetMapping("/register")
	public void register() {
		log.info("register Form 요청");
	}
	@PostMapping("/register")
	public void registerPost(RegisterVO register) {
		log.info("register 요청");
		
		//사용자가 보낸 값 가져오기
		log.info("아이디 : "+register.getUserid());
		log.info("비밀번호 : "+register.getPassword());
		log.info("비밀번호 확인 : "+register.getConfirm_password());
		log.info("전화번호 : "+register.getMobile());
	}
	
	@GetMapping("/update")
	public void update() {
		log.info("update Form 요청");
	}
	
	@PostMapping("/update")
	public void updatePost(@ModelAttribute("userid") String userid, String password) {
		log.info("update 요청");
		
		//@ModelAttribute
		//	- 도메인 객체의 이름 지정
		//	- Model의 기능 수행
		
//		model.addAttribute("userid", userid);
//		model.addAttribute("password", password);
	}
}
