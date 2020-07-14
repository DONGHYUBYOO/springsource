package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.CalculatorVO;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.GetProxy;

@Slf4j
@Controller
@RequestMapping("calc")
public class CalculatorController {

	@GetMapping("/calc")
	public void calc() {
		log.info("calc Form 요청");
	}
//	@PostMapping("/calc")
//	public String calcPost(@ModelAttribute("vo") CalculatorVO cal, Model model) {	
//		//Controller의 경우 페이지이동 방식이 Default가 Forward형태로 전송
//		//다음 페이지에서 값을 사용하지 않으려면 변수 형태로 사용해도 무관
//		//객체의 앞 글자를 소문자로 변환 후 사용 가능
//		log.info("calcResult Form 요청");
//
//		
//		//사용자 입력 값 가져오기
//		log.info("숫자1 : "+cal.getNum1());
//		log.info("수식 : "+cal.getOp());
//		log.info("숫자2 : "+cal.getNum2());
//		
//		int result=0;
//		switch (cal.getOp()) {
//		case "+":
//			result=Integer.parseInt(cal.getNum1())+Integer.parseInt(cal.getNum2());
//			break;
//		case "-":
//			result=Integer.parseInt(cal.getNum1())-Integer.parseInt(cal.getNum2());
//			break;
//		case "*":
//			result=Integer.parseInt(cal.getNum1())*Integer.parseInt(cal.getNum2());
//			break;
//		case "/":
//			result=Integer.parseInt(cal.getNum1())/Integer.parseInt(cal.getNum2());
//			break;
//		}
//		log.info("결과 : "+result);		
//		model.addAttribute("result", result);		
//		return "calc/calcResult";
//	}
	@PostMapping("/calc")
	public String calcPost(int num1, int num2, String op, Model model) {	
		//Controller의 경우 페이지이동 방식이 Default가 Forward형태로 전송
		//다음 페이지에서 값을 사용하지 않으려면 변수 형태로 사용해도 무관
		//객체의 앞 글자를 소문자로 변환 후 사용 가능
		log.info("calcResult Form 요청");
		
		//사용자 입력 값 가져오기
		log.info("숫자1 : "+num1);
		log.info("수식 : "+op);
		log.info("숫자2 : "+num2);
		
		int result=0;
		switch (op) {
		case "+":
			result=num1+num2;
			break;
		case "-":
			result=num1-num2;
			break;
		case "*":
			result=num1*num2;
			break;
		case "/":
			result=num1/num2;
			break;
		}
		log.info("결과 : "+result);		
		model.addAttribute("num1", num1);		
		model.addAttribute("op", op);		
		model.addAttribute("num2", num2);		
		model.addAttribute("result", result);		
		return "calc/calcResult";
	}
}
