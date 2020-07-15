package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public void registerGet() {
		log.info("파트너 입력 폼 요청");		
	}
	
	@PostMapping("/register")
	public void registerPost(PartnerVO partner) {
		log.info("파트너 정보 입력 요청");
		log.info(""+partner);
		service.create(partner);
	}
}
