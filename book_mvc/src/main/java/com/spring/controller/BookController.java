package com.spring.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping(value= {"/insertBook", "/deleteBook", "/updateBook"})
	public String handlerGet() {
		log.info("부적절한 요청");
		return "redirect:/";		
	}
	@GetMapping("/listBook")
	public String listBookForm(Model model) {
		log.info("book_selectAll.jsp Form 요청");
		List<BookVO> list=service.listBook();
		model.addAttribute("list", list);
				
		return "/book_selectAll";
	}
	
	@PostMapping("/insertBook")
	public String insertBook(BookVO book, RedirectAttributes rttr) {
		log.info("insertBook 처리 요청");
		log.info(""+book);
		
		try {
			if(service.insertBook(book)>0) {
				rttr.addFlashAttribute("info", "책 등록이 완료되었습니다.");
				return "redirect:/listBook";
			}else {
				rttr.addFlashAttribute("error", "책 등록이 실패하였습니다.");
				rttr.addFlashAttribute("tab", "insert");
				return "redirect:/";
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("error", "입력 정보를 확인해 주세요.");
			rttr.addFlashAttribute("tab", "insert");
			return "redirect:/";			
		}
	}
	
	@PostMapping("/deleteBook")
	public String deleteBook(String code, RedirectAttributes rttr) {
		log.info("deleteBook 처리 요청");
		log.info(""+code);
		
		try {
			if(service.deleteBook(code)>0) {
				rttr.addFlashAttribute("info", "책 삭제가 완료되었습니다.");
				return "redirect:/listBook";
			}else {
				rttr.addFlashAttribute("error", "책 삭제가 실패하였습니다.");
				rttr.addFlashAttribute("tab", "delete");
				return "redirect:/";
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("error", "입력 정보를 확인해 주세요.");
			rttr.addFlashAttribute("tab", "delete");
			return "redirect:/";
		}
	}
	
	@PostMapping("/updateBook")
	public String updateBook(String code, int price, RedirectAttributes rttr) {
		log.info("updateBook 처리 요청");
		log.info("코드 : "+code+" / 가격 : "+price);
		
		try {
			if(service.updateBook(code, price)>0) {
				rttr.addFlashAttribute("info", "가격 수정이 완료되었습니다.");
				rttr.addFlashAttribute("tab", "update");
				return "redirect:/listBook";
			}else {
				rttr.addFlashAttribute("error", "가격 수정을 실패하였습니다.");
				rttr.addFlashAttribute("tab", "update");
				return "redirect:/";
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("error", "입력 정보를 확인해 주세요.");
			return "redirect:/";
		}
	}
	
	@GetMapping("/getBook")
	public String getBook() {
		log.info("book_searchAll.jsp Form 요청");
		
		return "book_searchAll";
	}
	
	@GetMapping("/searchBook") 
	public String searchBookForm(RedirectAttributes rttr) {
		log.info("searchBook Form 요청");
		rttr.addFlashAttribute("tab", "search");
		return "redirect:/";
	}
	
	@PostMapping("/searchBook")
	public String searchBook(String criteria, String keyword, Model model, RedirectAttributes rttr) {
		log.info("searchBook 처리 요청");
		log.info("구분 : "+criteria+" / 검색어 : "+keyword);
		
		List<BookVO> search=service.getBook(criteria, keyword);
		if(!search.isEmpty()) {
			model.addAttribute("search", search);	
			return "/book_searchAll";
		}else {
			rttr.addFlashAttribute("error", "검색 내용이 없습니다.");
			rttr.addFlashAttribute("tab", "search");
			return "redirect:/";
		}	
	}	
}
		
		


