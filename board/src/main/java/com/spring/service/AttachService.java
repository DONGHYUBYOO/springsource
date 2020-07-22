package com.spring.service;

import java.util.List;

import com.spring.domain.AttachFileVO;

public interface AttachService {
	public int insertAttach(AttachFileVO attach);
	public int deleteAttach(int bno);
	public List<AttachFileVO> searchAttach(int bno);
}
