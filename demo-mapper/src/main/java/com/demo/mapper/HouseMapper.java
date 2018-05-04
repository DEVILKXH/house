package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.entity.House;
import com.demo.inner.base.mapper.BaseMapper;

public interface HouseMapper extends BaseMapper<House>{

	/**
	 * 获取各地区各楼盘的平均房价
	 * @return
	 */
	public List<House> getAvgPriceByBrand();
	
	/**
	 * 获取当天的平均房价
	 * @return
	 */
	public List<House> getAvgPrice();
	

	/**
	 * 获取各区当天房价
	 * @return
	 */
	public List<House> getAvgPriceByCity();
	
	/**
	 * 获取最近7天的平均房价信息
	 * @return
	 */
	public List<House> getAvgPriceByDay(@Param("city") String city);
}
