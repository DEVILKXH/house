package com.manager.service.impl.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PythonTest {

	public static void main(String args[]) {
		Process pr = null;
		String area = "海沧";
		String price = "马青路";
		String []_args = {"python3","E:/workspace/house/demo-web/src/main/resources/python/forecast.py",area,price};
		try {
			pr = Runtime.getRuntime().exec(_args);
			BufferedReader bf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line = null;
			while( (line = bf.readLine()) != null) {
				System.out.println(line);
			}
			bf.close();
			pr.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
