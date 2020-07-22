package com.spring.mapper;

import java.util.List;

import com.spring.domain.AttachFileVO;

public interface AttachMapper {
	public int insertAttach(AttachFileVO attach);
	public int deleteAttach(int bno);
	public List<AttachFileVO> searchAttach(int bno);
	public List<AttachFileVO> getYesterdayFiles();
}
