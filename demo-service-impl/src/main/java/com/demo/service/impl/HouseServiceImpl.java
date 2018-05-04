package com.demo.service.impl;

import java.util.List;

import com.demo.entity.House;
import com.demo.inner.base.serviceimpl.BaseServiceImpl;
import com.demo.mapper.HouseMapper;
import com.demo.service.HouseService;

public class HouseServiceImpl extends BaseServiceImpl<House, HouseMapper> implements HouseService{

	@Override
	public List<House> getAvgPriceByBrand() {
		return mapper.getAvgPriceByBrand();
	}

	@Override
	public List<House> getAvgPrice() {
		return mapper.getAvgPrice();
	}

	@Override
	public List<House> getAvgPriceByCity() {
		return mapper.getAvgPriceByCity();
	}

	@Override
	public List<House> getAvgPriceByDay(String city) {
		return mapper.getAvgPriceByDay(city);
	}

}
