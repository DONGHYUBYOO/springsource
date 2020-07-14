package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

public class MemberClient {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		MemberService service=(MemberService)ctx.getBean("member");
		
		//회원가입
		MemberVO vo = new MemberVO();
		vo.setUserid("ydh88");
		vo.setPassword("123");
		vo.setName("유동협");
		vo.setGender("남");
		vo.setEmail("yoodh9044@gmail.com");
		
		if(service.joinMember(vo)>0) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		//비밀번호 변경
		String userid="ydh88";		
		String current_password="123";		
		String new_password="12345";
		
		if(service.updateMember(userid, new_password, current_password)>0) {
			System.out.println("비밀번호 변경 성공");
		}else {
			System.out.println("비밀번호 변경 실패");
		}
		
		//회원탈퇴
		userid="hong123@";
		String password="hong123@";
		
		if(service.leaveMember(userid, password)>0) {
			System.out.println("회원탈퇴 성공");
		}else {
			System.out.println("회원탈퇴 실패");
		}
		
		//로그인
		userid="yoodh";
		password="123";
		MemberVO vo1=service.isLogin(userid, password);
		System.out.println(vo1);
		
		//회원리스트
		List<MemberVO> list=service.getList();
		for(MemberVO vo2:list) {
			System.out.println(vo2);
		}
	}
}
