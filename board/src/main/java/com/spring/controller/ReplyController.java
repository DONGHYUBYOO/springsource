package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.CriteriaVO;
import com.spring.domain.ReplyPageVO;
import com.spring.domain.ReplyVO;
import com.spring.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/replies/*")
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody ReplyVO reply) {
		log.info("댓글 등록"+reply);
		
		return service.insertReply(reply)>0 
				? new ResponseEntity<String>("success", HttpStatus.OK)
						: new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//댓글 하나 가져오기	http://localhost:8080/replies/
	@GetMapping("/{rno}")
	public ResponseEntity<ReplyVO> getReply(@PathVariable("rno") int rno) {
		log.info("댓글 가져오기 => rno : "+rno);
		return new ResponseEntity<>(service.getReply(rno), HttpStatus.OK);
	}
	
	@PutMapping("/{rno}")
	public ResponseEntity<String> modifyReply(@PathVariable("rno") int rno, @RequestBody ReplyVO reply) {
		log.info("댓글 수정 => rno : "+rno+" 내용 : "+reply);
		
		reply.setRno(rno);
		log.info("댓글 수정 => "+reply);
		return service.modifyReply(reply)>0 
				? new ResponseEntity<String>("success", HttpStatus.OK)
						: new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> deleteReply(@PathVariable("rno") int rno) {
		log.info("댓글 삭제 => rno : "+rno);
		
		return service.deleteReply(rno)>0 
				? new ResponseEntity<String>("success", HttpStatus.OK)
						: new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);		
	}	
	
	//글번호에 해당하는 댓글 리스트 가져오기
	//http://localhost:8080/replies/pages/bno/페이지번호
	@GetMapping("/pages/{bno}/{pageNum}")
	public ResponseEntity<ReplyPageVO> listReply(@PathVariable("bno") int bno, @PathVariable("pageNum") int pageNum){
		log.info("댓글 가져오기 => bno : "+bno+" page : "+pageNum);
		
		CriteriaVO criteria = new CriteriaVO(pageNum, 10);
		return new ResponseEntity<ReplyPageVO>(service.listReply(criteria, bno), HttpStatus.OK);
	}	
}
