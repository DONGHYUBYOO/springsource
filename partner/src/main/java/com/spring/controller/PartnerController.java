package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.PartnerVO;
import com.spring.service.PartnerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/partner")
public class PartnerController {

	@Autowired
	private PartnerService service;
	
	@GetMapping("/register")
	public void registPartner() {
		log.info("/partner/register.jsp 요청 - Form 화면");		
	}
	
	@PostMapping("/register")
	public String postRegister(PartnerVO partner, RedirectAttributes rttr) {
		log.info("partner 등록 - Form 화면");		
		log.info(""+partner);		
		try {
			if(service.registPartner(partner)>0) {			
				rttr.addFlashAttribute("info","Partner가 등록되었습니다..");
				return "redirect:/partner/list";
			}
			rttr.addFlashAttribute("error","Partner 등록이 실패하였습니다.");
			return "redirect:/partner/register";
		} catch (Exception e) {
			rttr.addFlashAttribute("error","입력 정보를 확인해 주세요.");
			return "redirect:/partner/register";
		}		
	}
	
	@GetMapping("/list")
	public void listPartner(PartnerVO partner, Model model) {
		log.info("/partner/list.jsp 요청 - Form 화면");		
		List<PartnerVO> list=service.listPartner();
		model.addAttribute("list",list);
	}
}
