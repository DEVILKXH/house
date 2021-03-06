package com.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.House;
import com.demo.inner.dto.EchartLine;
import com.demo.inner.dto.EchartLineResult;
import com.demo.inner.dto.EchartPie;
import com.demo.inner.dto.EchartPieResult;
import com.demo.mapper.HouseMapper;
import com.demo.service.HouseService;
import com.demo.service.PythonService;

@Controller
@RequestMapping(value = "house")
public class HouseController extends BaseController<House, HouseMapper,HouseService>{

	@Autowired
	private PythonService pythonService;

	/**
	 * 预测页面
	 * @return
	 */
	@RequestMapping(value = "/forecast.do")
	public String forecast(){
		return "forecast";
	}
	
	/**
	 * 调用python获取预测结果
	 * @param city
	 * @param brand
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getForecast.do")
	@ResponseBody
	public Map<String,Object> getForecast(String city,String brand,HttpServletRequest request){
		Map<String,Object> maps = new HashMap<>();
		List<House> list = service.getForecast(city, brand);
		List<List<String>> result = new ArrayList<>();
		int min = 1000;
		int max = 0;
		int maxp = 0;
		int minp = 1000000;
		for(House house: list){
			List<String> d = new ArrayList<>();
			if(house.getPrice() > maxp){
				maxp = house.getPrice();
			}
			if(house.getPrice() < minp){
				minp = house.getPrice();
			}
			if(house.getArea() > max){
				max = house.getArea();
			}
			if(house.getArea() < min){
				min = house.getArea();
			}
			d.add(house.getArea() + "");
			d.add(house.getPrice().toString());
			result.add(d);
		}
		maps.put("result", result);
		
		String path = request.getSession().getServletContext().getRealPath("/");
		String re = pythonService.forecast(city, brand, path);
		String []res = re.split("x");
		double b = Double.parseDouble(res[0]);
		double a = Double.parseDouble(res[1]);
		a *= 10000;
		if(Math.abs(b) < 0.01){
			b = b * 10000;
		}else if(Math.abs(b) < 0.1){
			b = b * 1000;
		}else{					
			b = b * 100;
		}
		
		int d = (maxp + minp) /2;
		int x = (max + min) / 2;
		
		a = d - b * x;
		maps.put("b", b);
		maps.put("a", a);
		maps.put("min", min);
		maps.put("max", max);
		maps.put("miny", b * min + a);
		maps.put("maxy", b * max + a);
		int maxup = (int)maxp/10000;
		int mindown = (int)minp/10000;
		maps.put("mindown", (maxup + 1) * 10000);
		maps.put("maxup", mindown * 10000);
		
		return maps;
	}
	
	@RequestMapping(value = "/index.do")
	public String index(Model model) {
		House house = getAvgPrice();
		try{
			int price = house.getPrice();
			List<Integer> prices = new ArrayList<>();
			while(price / 10 != 0){
				prices.add(price % 10);
				price /= 10;
			}
			prices.add(price % 10);
			Collections.reverse(prices);
			model.addAttribute("price",prices);
		}catch (Exception e) {
		}
		return "house";
	}
	
	/**
	 * 获取各地区各楼盘的平均房价
	 * @return
	 */
	@RequestMapping(value = "/getAvgPriceByBrand.do",method = RequestMethod.GET)
	@ResponseBody
	public EchartPieResult getAvgPriceByBrand(){
		List<House> list = service.getAvgPriceByBrand();
		EchartPieResult result = new EchartPieResult();
		for(House house: list){
			EchartPie pie = new EchartPie();
			pie.setName(house.getBrand());
			pie.setValue(house.getPrice().toString());
			result.add(pie);
		}
		return result;
	}
	
	/**
	 * 获取当天的平均房价
	 * @return
	 */
	public House getAvgPrice(){
		return service.getAvgPrice();
	}
	
	/**
	 * 获取各区当天房价
	 * @return
	 */
	@RequestMapping(value = "/getAvgPriceByCity.do",method = RequestMethod.GET)
	@ResponseBody
	public EchartLineResult getAvgPriceByCity(String type){
		List<House> list = service.getAvgPriceByCity(type);
		EchartLineResult result = new EchartLineResult();
		EchartLine line = new EchartLine();
		line.setName("平均房价");
		line.setType("bar");
		for(House house: list){
			line.addData(house.getPrice().toString());
			result.addxAxisData(house.getCity());
		}
		result.addSeries(line);
		return result;
	}
	
	@RequestMapping(value = "/getAvgPriceByCityOld.do",method = RequestMethod.GET)
	@ResponseBody
	public EchartPieResult getAvgPriceByCityOld(String type){
		List<House> list = service.getAvgPriceByCity(type);
		EchartPieResult result = new EchartPieResult();
		for(House house: list){
			EchartPie pie = new EchartPie();
			pie.setName(house.getCity());
			pie.setValue(house.getPrice().toString());
			result.add(pie);
		}
		return result;
	}
	
	/**
	 * 获取最近7天的平均房价信息
	 * @return
	 */
	@RequestMapping(value = "/getAvgPriceByDay.do",method = RequestMethod.GET)
	@ResponseBody
	public EchartLineResult getAvgPriceByDay(String city){
		List<House> list = service.getAvgPriceByDay(city);
		Map<String, EchartLine> map = new HashMap<>();
		EchartLineResult result = new EchartLineResult();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(House house: list){
			EchartLine line = new EchartLine();
			String key = house.getCity();
			if(map.containsKey(key)){
				line = map.get(key);
			}else{
				map.put(key, line);
				result.addSeries(line);
			}
			line.addData(house.getPrice().toString());
			line.setName(house.getCity());
			result.addxAxisData(sdf.format(house.getCreateTime()));
			result.addLedgendData(house.getCity());
		}
		return result;
	}
	
	/**
	 * 获取各地区最近7天的平均房价信息
	 * @return
	 */
	@RequestMapping(value = "/getAvgPriceByDay2.do",method = RequestMethod.GET)
	@ResponseBody
	public EchartPieResult getAvgPriceByDay2(String city){
		List<House> list = service.getAvgPriceByDay(city);
		EchartPieResult result = new EchartPieResult();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(House house: list){
			EchartPie pie = new EchartPie();
			pie.setName(sdf.format(house.getCreateTime()));
			pie.setValue(house.getPrice().toString());
			result.add(pie);
		}
		return result;
	}
}
