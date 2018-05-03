package com.demo.inner.util;

import org.springframework.stereotype.Component;

import com.demo.inner.dto.AjaxResult;


@Component
public class AjaxResultUtil {

	public <T> AjaxResult<T> getAjaxResult(Class<T> T){
		return new AjaxResult<T>();
	}
}
