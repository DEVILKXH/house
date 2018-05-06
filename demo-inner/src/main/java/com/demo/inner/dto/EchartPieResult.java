package com.demo.inner.dto;

import java.util.ArrayList;
import java.util.List;

public class EchartPieResult {

	List<EchartPie> data = new ArrayList<>();

	public List<EchartPie> getList() {
		return data;
	}

	public void setList(List<EchartPie> data) {
		this.data = data;
	}
	
	public void add(EchartPie pie){
		this.data.add(pie);
	}
}
