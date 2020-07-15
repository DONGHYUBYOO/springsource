package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.PartnerVO;
import com.spring.mapper.PartnerMapper;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	PartnerMapper mapper;

	@Override
	public int create(PartnerVO partner) {
		return mapper.create(partner);
	}
}
