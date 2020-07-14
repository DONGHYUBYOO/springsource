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
		vo.setCode("1990");
		vo.setTitle("오! 나의 귀신님");
		vo.setWriter("박보영");
		vo.setPrice(10000);
		
		if(service.insert(vo)) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 실패");			
		}
		
		//책 가격 수정
		BookVO vo1 = new BookVO();
		vo1.setCode("1988");
		vo1.setPrice(50000);
		
		if(service.update(vo1)) {
			System.out.println("가격 변경 성공");
		}else {
			System.out.println("가격 변경 실패");			
		}
		
		//책 삭제
		if(service.delete("111")) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");			
		}
		
		//책 검색		
		BookVO vo2=service.getBook("1988");
		System.out.println(vo2);
		System.out.println();
		
		//책 리스트
		List<BookVO> list=service.getList();
		for(BookVO vo3:list) {
			System.out.println(vo3);
		}	
	}
}
