package com.demo.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.House2;
import com.demo.inner.dto.EchartLine;
import com.demo.inner.dto.EchartLineResult;
import com.demo.inner.dto.EchartPie;
import com.demo.inner.dto.EchartPieResult;
import com.demo.mapper.House2Mapper;
import com.demo.service.House2Service;

@Controller
@RequestMapping(value = "/house2")
public class House2Controller extends BaseController<House2, House2Mapper, House2Service>{

	/**
	 * @info 获取各地区每个月的房价
	 * @param area
	 * @return
	 */
	@RequestMapping(value = "/getAvgPriceByMonth.do",method = RequestMethod.GET)
	@ResponseBody
	public EchartPieResult getAvgPriceByDay2(String area){
		List<House2> list = service.getAvgPriceByMonth(area);
		EchartPieResult result = new EchartPieResult();
		for(House2 house: list){
			EchartPie pie = new EchartPie();
			pie.setName(house.getYear() + house.getMonth());
			pie.setValue(house.getPrice().toString());
			result.add(pie);
		}
		return result;
	}
	
	/**
	 * @info 获取各年的平均房价
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/getAvgPriceByCity.do",method = RequestMethod.GET)
	@ResponseBody
	public EchartLineResult getAvgPriceByCity(){
		List<House2> list = service.getAvgPriceByYear();
		Map<String, EchartLine> map = new HashMap<>();
		EchartLineResult result = new EchartLineResult();
		for(House2 house: list){
			EchartLine line = new EchartLine();
			String key = house.getArea();
			if(map.containsKey(key)){
				line = map.get(key);
			}else{
				map.put(key, line);
				result.addSeries(line);
			}
			line.addData(house.getPrice());
			line.setName(house.getArea());
			result.addxAxisData(house.getYear());
			result.addLedgendData(house.getArea());
		}
		return result;
	}
}
