package com.demo.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import com.demo.service.PythonService;

@Service
public class PythonServiceImpl implements PythonService{

	public String forecast(String city,String brand,String path){
		Process pr = null;
		String []_args = {"python3","E:/workspace/house/demo-web/src/main/resources/python/forecast.py",city,brand};
		String result = "";
		try {
			pr = Runtime.getRuntime().exec(_args);
			BufferedReader bf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line = null;
			while( (line = bf.readLine()) != null) {
				result += line;
				result += "x";
			}
			bf.close();
			pr.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
