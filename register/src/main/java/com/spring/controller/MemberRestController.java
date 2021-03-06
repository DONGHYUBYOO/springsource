package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthVO;
import com.spring.domain.ChangeVO;
import com.spring.domain.LoginVO;
import com.spring.domain.RegisterVO;
import com.spring.service.MemberService;
import com.spring.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberRestController {

	@Autowired
	private MemberService service;
	
	@DeleteMapping("/leave")
	public ResponseEntity<String> leaveDelete(@RequestBody ChangeVO change, HttpSession session) {
		log.info("회원탈퇴 => "+change);
		String pwd=service.checkPWD(change);
		
			if(change.newPasswordEqualsConfirm()) {
				if(service.leave(change.getUserid(), change.getPassword())>0) {
					session.removeAttribute("auth");
					return new ResponseEntity<String>("success", HttpStatus.OK);
				}
			}			
		return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/changePWD")
	public ResponseEntity<String> changePWDPut(@RequestBody ChangeVO change, HttpSession session, RedirectAttributes rttr) {
		log.info("비밀번호 변경");
		
		AuthVO auth=(AuthVO) session.getAttribute("auth");
		change.setUserid(auth.getUserid());
		log.info("비밀번호 변경 => "+change);
		
		String pwd=service.checkPWD(change);
		if(pwd.equals(change.getPassword())) {
			if(change.newPasswordEqualsConfirm()) {
				if(service.changePWD(change)>0) {
					session.removeAttribute("auth");
					rttr.addFlashAttribute("info", "비밀번호가 변경 완료, 다시 로그인해 주세요.");
					return new ResponseEntity<String>("success", HttpStatus.OK);
				}else {
					return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);					
				}
			}else {
				return new ResponseEntity<String>("conf_pwd", HttpStatus.BAD_REQUEST);				
			}
		}else {
			return new ResponseEntity<String>("pwd", HttpStatus.BAD_REQUEST);			
		}
	}
}
