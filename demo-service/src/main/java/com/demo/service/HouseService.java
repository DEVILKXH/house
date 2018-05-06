package com.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.entity.House;
import com.demo.inner.base.service.BaseService;
import com.demo.mapper.HouseMapper;

public interface HouseService extends BaseService<House, HouseMapper>{

	/**
	 * 获取面积-房价
	 * @return
	 */
	public List<House> getForecast(String city,String brand);
	
	/**
	 * 获取各地区各楼盘的平均房价
	 * @return
	 */
	public List<House> getAvgPriceByBrand();
	
	/**
	 * 获取当天的平均房价
	 * @return
	 */
	public House getAvgPrice();
	

	/**
	 * 获取各区当天房价
	 * @return
	 */
	public List<House> getAvgPriceByCity(String type);
	
	/**
	 * 获取最近7天的平均房价信息
	 * @return
	 */
	public List<House> getAvgPriceByDay(@Param("city") String city);
}
