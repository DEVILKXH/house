package com.demo.service;

import java.util.List;

import com.demo.entity.House2;
import com.demo.inner.base.service.BaseService;
import com.demo.mapper.House2Mapper;

public interface House2Service extends BaseService<House2, House2Mapper>{
	List<House2> getAvgPriceByMonth(String area);
	
	List<House2> getAvgPriceByYear();
	
	void deleteAll();
}
