package com.spring.service;

import java.util.List;

import com.spring.domain.PersonVO;

public interface PersonService {
	public void insertPerson(String id,String name);
	public String getPerson(String id);
	public List<PersonVO> listPerson();
	public boolean updatePerson(String name, String id);
	public int deletePerson(String id);	
}
