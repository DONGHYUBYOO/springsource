package com.spring.service;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerService {
	public int registPartner(PartnerVO partner);
	public List<PartnerVO> listPartner();	
}
