package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.AttachFileVO;
import com.spring.mapper.AttachMapper;

@Service
public class AttachServiceImpl implements AttachService {

	@Autowired
	AttachMapper mapper;
	
	@Override
	public int insertAttach(AttachFileVO attach) {
		return mapper.insertAttach(attach);
	}

	@Override
	public int deleteAttach(int bno) {
		return mapper.deleteAttach(bno);
	}

	@Override
	public List<AttachFileVO> searchAttach(int bno) {
		return mapper.searchAttach(bno);
	}
}
