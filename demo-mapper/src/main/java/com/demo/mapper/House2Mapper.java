package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.entity.House2;
import com.demo.inner.base.mapper.BaseMapper;

public interface House2Mapper extends BaseMapper<House2>{
	List<House2> getAvgPriceByMonth(@Param("area") String area);
	
	List<House2> getAvgPriceByYear();
	
	void deleteAll();
}