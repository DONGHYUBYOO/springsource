package com.spring.mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonVO;
import com.spring.service.PersonService;

public class PersonClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		PersonService person=(PersonService)ctx.getBean("person");
		
		//person.insertPerson("삑삑이", "엄신용용죽겠지");
		System.out.println(person.getPerson("hong123"));
		
		if(person.updatePerson("엄신용가리", "삑삑이")) {
			System.out.println("UPDATE 성공");
		}else {
			System.out.println("UPDATE 실패");
		}
		
		if(person.deletePerson("내카트열리짱")>0) {
			System.out.println("DELETE 성공");			
		}else {
			System.out.println("DELETE 실패");			
		}
		
		List<PersonVO> list=person.listPerson();
		for(PersonVO vo:list) {
			System.out.println(vo);
		}	
	}
}
