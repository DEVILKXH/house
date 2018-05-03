package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.entity.House;

import tk.mybatis.mapper.common.Mapper;

public interface HouseMapper extends Mapper<House>{

	/**
	 * 获取当天的平均房价
	 * @return
	 */
	public List<House> getAvgPrice();
	

	/**
	 * 获取最近7天的平均房价信息
	 * @return
	 */
	public List<House> getAvgPriceByDay(@Param("city") String city);
}
