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
		
		int result=0;
		BoardVO vo = new BoardVO();
		vo.setTitle("스프링게시판");
		vo.setContent("스프링 게시판 연습");
		vo.setWriter("안유성");
		
		//게시글 등록
		result=service.insertBoard(vo);
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		//게시글 가져오기
		List<BoardVO> list=service.getList();
		for(BoardVO vo1:list) {
			System.out.println(vo1);
		}
	}
}
