package com.spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j	//lombok에서 slf4j를 annotation으로 설정
public class LogTest {
	
//	private static final Logger logger=LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
//		logger.error("error 레벨");
//		logger.warn("warn 레벨");
//		logger.info("info 레벨");
//		logger.debug("debug 레벨");
//		logger.trace("trace 레벨");
		
		log.error("error 레벨");
		log.warn("warn 레벨");
		log.info("info 레벨");
		log.debug("debug 레벨");
		log.trace("trace 레벨");
	}
}
