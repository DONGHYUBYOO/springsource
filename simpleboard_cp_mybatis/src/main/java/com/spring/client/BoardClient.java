package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

public class BoardClient {
	public static void main(String[] args) {
		//컨테이너 구동
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		//LookUp
		BoardService service=(BoardService)ctx.getBean("board");
		
		//게시글 등록
		BoardVO vo = new BoardVO();
		vo.setTitle("스프링게시판");
		vo.setContent("스프링 게시판 연습");
		vo.setWriter("엄신용용");
		
		if(service.insertBoard(vo)>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		//게시글 수정
		BoardVO vo1 = new BoardVO();
		vo1.setBno(22);
		vo1.setTitle("스프링 게시판 MyBatis@");
		vo1.setContent("스프링 게시판 수정@");
		
		if(service.updateBoard(vo1)>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		//게시글 삭제
		BoardVO vo2 = new BoardVO();
		vo2.setBno(24);
		
		if(service.deleteBoard(vo2)>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		//게시글 검색
		BoardVO vo3=service.getBoard(23);
		System.out.println(vo3);
		System.out.println();
		//게시글 가져오기
		List<BoardVO> list=service.getList();
		for(BoardVO vo4:list) {
			System.out.println(vo4);
		}
	}
}
