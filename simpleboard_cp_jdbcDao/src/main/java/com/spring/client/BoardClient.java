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
//		int result=0;
//		BoardVO vo = new BoardVO();
//		vo.setTitle("스프링게시판");
//		vo.setContent("스프링 게시판 연습");
//		vo.setWriter("박유성모마리아");
//		
//		result=service.insertArticle(vo);
//		if(result>0) {
//			System.out.println("등록 성공");
//		}else {
//			System.out.println("등록 실패");
//		}
//		
//		//게시글 수정
//		BoardVO vo1 = new BoardVO();
//		vo1.setBno(3);
//		vo1.setTitle("스프링 게시판 JDBC");
//		vo1.setContent("스프링 게시판 수정");
//		service.updateArticle(vo1);
//		
//		result=service.updateArticle(vo1);
//		if(result>0) {
//			System.out.println("수정 성공");
//		}else {
//			System.out.println("수정 실패");
//		}
//		
//		//게시글 삭제
//		BoardVO vo2 = new BoardVO();
//		vo2.setBno(4);
//		
//		result=service.deleteArticle(vo2);
//		if(result>0) {
//			System.out.println("삭제 성공");
//		}else {
//			System.out.println("삭제 실패");
//		}
//		
//		//게시글 한개 가져오기
//		BoardVO vo3=service.getArticle(22);
//		System.out.println(vo3);
//		
		//게시글 가져오기
		List<BoardVO> list=service.getList();
		for(BoardVO vo4:list) {
			System.out.println(vo4);
		}
	}
}
