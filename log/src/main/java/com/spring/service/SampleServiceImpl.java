package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mapper.SampleMapper1;
import com.spring.mapper.SampleMapper2;

@Service("sample")
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	private SampleMapper1 mapper1;
	@Autowired
	private SampleMapper2 mapper2;
	
	@Transactional(rollbackFor = Exception.class)	//롤백 발생시 Exception으로 연결
	@Override	
	public void addData(String data) {
		//tbl_sample1 과 tbl_sample2에 데이터 삽입
		mapper1.insertCol1(data);
		mapper2.insertCol2(data);
	}
}
