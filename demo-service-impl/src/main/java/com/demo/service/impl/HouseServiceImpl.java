package com.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.House;
import com.demo.inner.base.serviceimpl.BaseServiceImpl;
import com.demo.mapper.HouseMapper;
import com.demo.service.HouseService;

@Service
public class HouseServiceImpl extends BaseServiceImpl<House, HouseMapper> implements HouseService{

	@Override
	public List<House> getAvgPriceByBrand() {
		return mapper.getAvgPriceByBrand();
	}

	@Override
	public House getAvgPrice() {
		return mapper.getAvgPrice();
	}

	@Override
	public List<House> getAvgPriceByCity(String type) {
		return mapper.getAvgPriceByCity(type);
	}

	@Override
	public List<House> getAvgPriceByDay(String city) {
		return mapper.getAvgPriceByDay(city);
	}

	@Override
	public List<House> getForecast(String city,String brand) {
		return mapper.getForecast(city,brand);
	}

}
