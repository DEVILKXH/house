package com.demo.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.service.House2Service;
import com.demo.service.PythonService;

@Service
public class PythonServiceImpl implements PythonService{

	@Autowired
	private House2Service house2Service;
	
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

	@Override
	public void getNew() {
		Process pr = null;
		String []_args = {"python3","D:/workspace/house2/anjuke.py"};
		try {
			pr = Runtime.getRuntime().exec(_args);
//			BufferedReader bf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//			String line = null;
//			String result = "";
//			while( (line = bf.readLine()) != null) {
//				result += line;
//				result += "x";
//			}
//			System.out.println(result);
//			bf.close();
			pr.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getOld() {
		Process pr = null;
		String []_args = {"python3","D:/workspace/house2/anjuke_old.py"};
		try {
			pr = Runtime.getRuntime().exec(_args);
//			BufferedReader bf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//			String line = null;
//			String result = "";
//			while( (line = bf.readLine()) != null) {
//				result += line;
//				result += "x";
//			}
//			System.out.println(result);
//			bf.close();
			pr.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getHistory() {
//		house2Service.deleteAll();
		Process pr = null;
		String []_args = {"python3","D:/workspace/house2/month.py"};
		try {
			pr = Runtime.getRuntime().exec(_args);
			BufferedReader bf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line = null;
			String result = "";
			while( (line = bf.readLine()) != null) {
				result += line;
				result += "x";
			}
			System.out.println(result);
			bf.close();
			pr.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		new PythonServiceImpl();
	}
	
	public PythonServiceImpl(){
		this.getHistory();
	}
}
