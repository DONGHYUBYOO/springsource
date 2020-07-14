package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.ArticleVO;
import com.spring.domain.CriteriaVO;
import com.spring.domain.ModifyVO;
import com.spring.domain.PageVO;
import com.spring.domain.ReadVO;
import com.spring.domain.RegistVO;
import com.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/list")
	public void listArticle(@ModelAttribute("criteria") CriteriaVO criteria, Model model) {
		log.info("/board/list.jsp Form 요청");

		//현재 페이지에 보여줄 게시물
		List<ArticleVO> list=service.listArticle(criteria);
		model.addAttribute("list", list);		
		//하단의 페이지나누기와 관련된 정보
		model.addAttribute("pageVO", new PageVO(criteria, service.totalArticle(criteria)));
	}
	
	@GetMapping("/register")
	public void registerForm() {
		log.info("/board/register.jsp Form 요청");
	}
	
	@PostMapping("/register")
	public String register(RegistVO regist, RedirectAttributes rttr) {
		log.info("Regist 처리 요청");
		log.info(""+regist);
		try {
			if(service.insertArticle(regist)>0) {
				rttr.addFlashAttribute("result", regist.getBno());
				return "redirect:/board/list";			
			}else {
				return "/board/register";
			}
		} catch (Exception e) {
			return "/board/register";
		}
		
	}		
	
	//같은 작업을 하는 Controller이기 때문에 value로 그룹화 하여 사용 가능
	//현재 VO를 모두 나눠놔서 사용불가
//	@GetMapping(value= {"/read","/modify"})
//	public void readForm(int bno, Model model) {
//		log.info("/board/read.jsp Form 요청");
//		log.info(""+bno);
//		
//		ReadVO read=service.getArticle(bno);
//		model.addAttribute("read",read);
//	}
	
	@GetMapping("/read")
	public void readForm(int bno, CriteriaVO criteria, Model model) {
		log.info("/board/read.jsp Form 요청");
		log.info(""+bno);
		log.info(""+criteria);
		
		ReadVO read=service.getArticle(bno);
		model.addAttribute("read",read);
	}
	
	@GetMapping("/modify")
	public void modifyForm(int bno, CriteriaVO criteria, Model model) {
		log.info("/board/modify.jsp Form 요청");
		log.info(""+bno);
		log.info(""+criteria);
		
		ReadVO modify=service.getArticle(bno);
		model.addAttribute("modify",modify);		
	}
	
	@PostMapping("/modify")
	public String modify(ModifyVO modify, CriteriaVO criteria, RedirectAttributes rttr) {
		log.info("Modify 처리 요청");
		log.info(""+modify);
		//get => post로 페이지 변환없이(주소의 변경없이) method만 변경되었기 때문에 CriteriaVO의 값을 그대로 유지 
		log.info(""+criteria);
		
		//rttr.addFlashAttribute("", "")	//${}로 받아서 사용
		rttr.addAttribute("bno", modify.getBno());	//url에 알아서 따라간다.	== read?bno=3	parameter방식
		rttr.addAttribute("pageNum", criteria.getPageNum());
		rttr.addAttribute("amount", criteria.getAmount());
		rttr.addAttribute("type", criteria.getType());
		rttr.addAttribute("keyword", criteria.getKeyword());
		
		try {
			if(service.modifyArticle(modify)>0) {
//				return "redirect:/board/read?bno="+modify.getBno();
				return "redirect:/board/read";
			}else {
//				return "redirect:/board/modify?bno="+modify.getBno();
				return "redirect:/board/modify";
			}
		} catch (Exception e) {
//			return "redirect:/board/modify?bno="+modify.getBno();
			return "redirect:/board/modify";
		}
	}
	
	@PostMapping("/remove")
	public String remove(int bno, CriteriaVO criteria, RedirectAttributes rttr) {
		log.info("Remove 처리 요청");
		log.info(""+bno);
		log.info(""+criteria);
		rttr.addAttribute("pageNum", criteria.getPageNum());
		rttr.addAttribute("amount", criteria.getAmount());
		rttr.addAttribute("type", criteria.getType());
		rttr.addAttribute("keyword", criteria.getKeyword());
		
		if(service.removeArticle(bno)>0) {
			rttr.addFlashAttribute("result","remove");
			return "redirect:/board/list";
		}else {
			rttr.addAttribute("bno", bno);
			return "redirect:/board/modify";
		}
	}
	
//	@GetMapping("/remove")
//	public String remove(int bno, RedirectAttributes rttr) {
//		log.info("Remove 처리 요청");
//		log.info(""+bno);		
//		
//		if(service.removeArticle(bno)>0) {
//			return "redirect:/board/list";
//		}else {
//			rttr.addAttribute("bno", bno);
//			return "redirect:/board/modify";
//		}
//	}
}
