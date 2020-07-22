package com.spring.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.ArticleVO;
import com.spring.domain.AttachFileVO;
import com.spring.domain.CriteriaVO;
import com.spring.domain.ModifyVO;
import com.spring.domain.PageVO;
import com.spring.domain.ReadVO;
import com.spring.domain.RegistVO;
import com.spring.service.AttachService;
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
		if(regist.getAttachList()!=null) {
			regist.getAttachList().forEach(attach -> log.info(""+attach));
		}
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
		log.info(""+read);
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
		
		//현재 글번호에 해당하는 첨부파일 목록을 서버에서 삭제하기 위해서
		//bno에 해당하는 첨부파일 리스트 가져오기
		List<AttachFileVO> attachList=service.searchAttach(bno);
		
		if(service.removeArticle(bno)>0) {
			deleteFiles(attachList);
			rttr.addFlashAttribute("result","remove");
			return "redirect:/board/list";
		}else {
			rttr.addAttribute("bno", bno);
			return "redirect:/board/modify";
		}
	}
	
	//첨부파일 가져오기 컨트롤러 작성
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachFileVO>> getAttachList(int bno) {
		return new ResponseEntity<List<AttachFileVO>>(service.searchAttach(bno),HttpStatus.OK);
	}
	
	//게시글 삭제 시 서버 폴더에 첨부파일 삭제
	private void deleteFiles(List<AttachFileVO> attachList) {
		if(attachList == null || attachList.size() == 0) {
			return;
		}
		for(AttachFileVO vo:attachList) {
			Path file=Paths.get("d:\\JAVA_Upload\\", vo.getUploadPath()+"\\"+vo.getUuid()+"_"+vo.getFileName());
			
			try {
				//일반파일, 이미지 원본 파일 삭제
				Files.deleteIfExists(file);
				
				//썸네일 삭제
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumb=Paths.get("d:\\JAVA_Upload\\", vo.getUploadPath()+"\\s_"+vo.getUuid()+"_"+vo.getFileName());
					Files.delete(thumb);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
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
