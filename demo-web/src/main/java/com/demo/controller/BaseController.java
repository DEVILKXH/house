/**
 * @author kexiaohong
 * @version 1.0 2017年12月16日
 *
 */
package com.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.entity.BaseEntity;
import com.demo.entity.User;
import com.demo.inner.base.mapper.BaseMapper;
import com.demo.inner.base.service.BaseService;
import com.demo.inner.dto.AjaxResult;
import com.demo.service.UserService;
import com.github.pagehelper.Page;

public class BaseController<T extends BaseEntity, E extends BaseMapper<T>, S extends BaseService<T, E>> {

	@Autowired
	protected S service;
	
	@Autowired
	protected UserService userService;
	
	@RequestMapping(value = "/insertSelective.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<T> insertSelective(@RequestBody T record){
		AjaxResult<T> ajax = new AjaxResult<T>();
		if(record.getClass()  == User.class){
			UserService userService = (UserService) service;
			List<User> list = userService.select((User)record);
			if(null != list && list.size() > 0){
				ajax.setStatus("500");
				ajax.setMessage("该用户名已存在");
				return ajax;
			}
		}
		BaseEntity baseEntity = (BaseEntity)record;
		baseEntity.setId(UUID.randomUUID().toString());
		int flag = service.insertSelective(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("插入失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("插入成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getId()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/insert.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<T> insert(@RequestBody T record){
		AjaxResult<T> ajax = new AjaxResult<T>();
		if(record.getClass()  == User.class){
			User user = (User)record;
			UserService userService = (UserService) service;
			List<User> list = userService.select(user);
			if(null != list && list.size() > 0){
				ajax.setStatus("500");
				ajax.setMessage("该用户名已存在");
				return ajax;
			}
		}
		BaseEntity baseEntity = (BaseEntity)record;
		baseEntity.setId(UUID.randomUUID().toString());
		int flag = service.insert(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("插入失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("插入成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getId()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/selectOne.do",method={RequestMethod.POST})
	@ResponseBody
	public T selectOne(@RequestBody T record){
		T example =  getExample(record);
		List<T> records = service.selectByExample(example);
		if(null == records || records.size() == 0 ){
			return null;
		}
		return records.get(0);
	}
	
	@RequestMapping(value = "/updateSelective.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<T> updateSelective(@RequestBody T record){
		BaseEntity baseEntity = (BaseEntity) record;
		AjaxResult<T> ajax = new AjaxResult<T>();
		int flag = service.updateByPrimaryKeySelective(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("更新失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("更新成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getId()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/update.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<T> update(@RequestBody T record){
		BaseEntity baseEntity = (BaseEntity) record;
		AjaxResult<T> ajax = new AjaxResult<T>();
		int flag = service.updateByPrimaryKey(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("更新失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("更新成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getId()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/delete.do",method={RequestMethod.GET})
	@ResponseBody
	public AjaxResult<T> delete(T record){
		AjaxResult<T> ajax = new AjaxResult<T>();
		int flag = service.deleteByPrimaryKey(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("删除失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("删除成功");
		}
		return ajax;
	}
	
	public T getExample(T record){
		return null;
	}

	@RequestMapping(value = "/getPage.do")
	@ResponseBody
	public Page<T> getPage(T record, Page<T> page){
		return null;
	}

	@RequestMapping(value = "/getLists.do")
	@ResponseBody
	public List<T> getList(T record){
		return service.select(record);
	}
}
