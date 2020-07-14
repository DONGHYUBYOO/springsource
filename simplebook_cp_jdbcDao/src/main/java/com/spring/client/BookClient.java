package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

public class BookClient {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");		
		BookService service=(BookService)ctx.getBean("book");
		
		//책 등록
		BookVO vo = new BookVO();
		vo.setCode("1988");
		vo.setTitle("이것이 스프링이다");
		vo.setWriter("박진경 선생님");
		vo.setPrice(30000);
		
		if(service.insertBook(vo)>0) {
			System.out.println("책 등록 성공");
		}else {
			System.out.println("책 등록 실패");
		}
		
		//책 가격 수정
		BookVO vo1 = new BookVO();
		vo1.setCode("111");
		vo1.setPrice(111);
		
		if(service.updateBook(vo1)>0) {
			System.out.println("가격 변경 성공");
		}else {
			System.out.println("가격 변경 실패");
		}
		
		//책 삭제
		String code="1004";
		
		if(service.deleteBook(code)>0) {
			System.out.println("책 삭제 성공");
		}else {
			System.out.println("책 삭제 실패");
		}
		
		//책 검색
		code="111";
		BookVO vo2=service.getBook(code);
		System.out.println(vo2);
		
		//책 리스트
		List<BookVO> list=service.getList();
		for(BookVO vo3:list) {
			System.out.println(vo3);
		}	
	}
}
