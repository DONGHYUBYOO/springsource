package com.spring.mapper;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerMapper {
	public int create(PartnerVO partner);
	public List<PartnerVO> list();
}
