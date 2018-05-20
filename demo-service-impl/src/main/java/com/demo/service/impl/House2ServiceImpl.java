package com.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.House2;
import com.demo.inner.base.serviceimpl.BaseServiceImpl;
import com.demo.mapper.House2Mapper;
import com.demo.service.House2Service;

@Service
public class House2ServiceImpl extends BaseServiceImpl<House2, House2Mapper> implements House2Service{

	@Override
	public List<House2> getAvgPriceByMonth(String area) {
		return mapper.getAvgPriceByMonth(area);
	}

	@Override
	public List<House2> getAvgPriceByYear() {
		return mapper.getAvgPriceByYear();
	}

	@Override
	public void deleteAll() {
		mapper.deleteAll();
	}

}
