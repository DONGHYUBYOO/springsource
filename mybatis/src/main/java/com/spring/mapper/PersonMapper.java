package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.spring.domain.PersonVO;


public interface PersonMapper {
	//annotation 설정 방식
//	@Insert("insert into person(id, name) values(#{id}, #{name})")
//	public int insertPerson(@Param("id") String id, @Param("name") String name);
	
	//xml 설정 방식
	public int insertPerson(@Param("id") String id, @Param("name") String name);	
	public String getPerson(@Param("id") String id);	
	public List<PersonVO> listPerson();	
	public int updatePerson(@Param("name") String name, @Param("id") String id);	
	public int deletePerson(@Param("id") String id);
}
