package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.PersonVO;
import com.spring.mapper.PersonMapper;

@Service("person")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper mapper;
	
	@Override
	public void insertPerson(String id, String name) {
		System.out.println(mapper.insertPerson(id, name)==0?"실패":"성공");		
	}
	@Override
	public String getPerson(String id) {
		return mapper.getPerson(id);
	}
	@Override
	public List<PersonVO> listPerson() {
		return mapper.listPerson();
	}	@Override
	public boolean updatePerson(String name, String id) {
		return mapper.updatePerson(name, id)==0?false:true;
	}
	@Override
	public int deletePerson(String id) {
		return mapper.deletePerson(id);
	}
}
