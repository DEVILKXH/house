package com.demo.service;

public interface PythonService {

	public String forecast(String city,String brand,String path); 
	
	public void getNew();
	
	public void getOld();
	
	public void getHistory();
	
}
