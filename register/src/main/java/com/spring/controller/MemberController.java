package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResizableByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthVO;
import com.spring.domain.ChangeVO;
import com.spring.domain.LoginVO;
import com.spring.domain.RegisterVO;
import com.spring.service.MemberService;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService service;
	
	@GetMapping("/login")
	public void login() {
		log.info("login Form 요청");
	}
	
	@PostMapping("/login")
	public String loginPost(LoginVO login, HttpSession session) {
		log.info("login 처리");
		log.info(""+login);
		
		AuthVO auth=service.isLogin(login);
		if(auth==null) {
			
			return "/member/login";
		}
		//세션에 값 담기
		session.setAttribute("auth", auth);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("logout 처리");
		session.invalidate();
		//session.removeAttribute("auth");
		return "redirect:/";
	}
	
	@GetMapping("/changePWD")
	public void changePWD() {
		log.info("changePWD Form 요청");		
	}
	
	//비밀번호 변경 요청 처리 컨트롤러 생성
//	@PostMapping("/changePWD")
//	public String changPWDPost(ChangeVO change, HttpSession session, RedirectAttributes rttr) {
//		log.info("chagePWD 처리");
//		AuthVO auth=(AuthVO) session.getAttribute("auth");
//		change.setUserid(auth.getUserid());		
//		log.info(""+change);
//		
//		//userid와 일치하는 비밀번호 추출;
//		//사용자가 입력한 현재 비밀번호와 일치하면	
//		if(service.checkPWD(change).equals(change.getPassword())) {
//			//new_pwd와 confirm_pwd가 같으면
//			if(change.newPasswordEqualsConfirm()) {
//				//수정작업 시작
//				if(service.changePWD(change)>0) {
//					session.invalidate();
//					rttr.addFlashAttribute("info", "비밀번호 변경 성공, 다시 로그인 해주세요.");
//					return "redirect:/";
//				}
//			}else {
//				rttr.addFlashAttribute("error", "입력하신 새 비밀번호가 일치하지 않습니다.");
//				return "redirect:/member/changePWD";
//			}
//		}else {
//			rttr.addFlashAttribute("error", "현재 비밀번호를 확인해 주세요.");
//			return "redirect:/member/changePWD";
//		}
//		return "redirect:/member/changePWD";
//	}
	
	@GetMapping("/leave")
	public void leave() {
		log.info("leave Form 요청");
	}
	
//	@PostMapping("/leave")
//	public String leavePost(String userid, String password, HttpSession session, RedirectAttributes rttr) {
//		log.info("leave 처리");
//		log.info(""+userid);
//		log.info(""+password);
//		
//		//userid와 일치하는 비밀번호 추출
//		AuthVO auth=(AuthVO)session.getAttribute("auth");
//		log.info(""+auth);
//		//사용자가 입력한 현재 비밀번호와 일치하면	
//		if(auth.getPassword().equals(password)) {
//			//삭제작업 시작
//			if(service.leave(userid, password)>0) {
//				session.invalidate();
//				rttr.addFlashAttribute("info", "회원탈퇴가 완료되었습니다.");
//				return "redirect:/";
//			}else {
//				//DB 작업 실패시
//				rttr.addFlashAttribute("error", "회원탈퇴가 실패했습니다. 다시 시도해 주세요.");
//				return "redirect:/member/leave";
//			}
//		}else {
//			//비밀번호가 일치 하지 않을때
//			rttr.addFlashAttribute("error", "비밀번호를 확인해 주세요.");
//			return "redirect:/member/leave";
//		}
//	}
}
