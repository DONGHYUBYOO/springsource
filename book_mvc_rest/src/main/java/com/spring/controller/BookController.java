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
		return "/book_selectAll";
	}
	
	@GetMapping("/info")
	public String info() {
		log.info("book_info.jsp Form 요청");
		return "/book_info";
	}
	@GetMapping("/insert")
	public String insert() {
		log.info("book_insert.jsp Form 요청");
		return "/book_insert";
	}
}
		
		


