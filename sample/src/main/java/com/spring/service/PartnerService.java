package com.spring.service;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerService {
	public int create(PartnerVO partner);
	public List<PartnerVO> list();
}
