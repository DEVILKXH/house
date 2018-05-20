package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.inner.dto.AjaxResult;
import com.demo.inner.util.AjaxResultUtil;
import com.demo.service.PythonService;

@Controller
@RequestMapping(value = "/python")
public class PythonController {

	@Autowired
	private PythonService pythonService;
	
	@Autowired
	private AjaxResultUtil ajaxResultUtil;
	
	@RequestMapping(value = "/getNew.do")
	@ResponseBody
	public AjaxResult<String> getNew(){
		pythonService.getNew();
		return ajaxResultUtil.getAjaxResult(String.class);
	}
	
	@RequestMapping(value = "/getOld.do")
	@ResponseBody
	public AjaxResult<String> getOld(){
		pythonService.getOld();
		return ajaxResultUtil.getAjaxResult(String.class);
	}
	
	@RequestMapping(value = "/getHistory.do")
	@ResponseBody
	public AjaxResult<String> getHistory(){
		pythonService.getHistory();
		return ajaxResultUtil.getAjaxResult(String.class);
	}
}
