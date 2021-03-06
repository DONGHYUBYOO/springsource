package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.PartnerVO;
import com.spring.mapper.PartnerMapper;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	PartnerMapper mapper;
	
	@Override
	public int registPartner(PartnerVO partner) {
		return mapper.registPartner(partner);
	}

	@Override
	public List<PartnerVO> listPartner() {
		return mapper.listPartner();
	}

}
