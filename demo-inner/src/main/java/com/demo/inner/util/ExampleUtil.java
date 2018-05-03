/**
 * @author kexiaohong
 * @version 1.0 2018年1月26日
 *
 */
package com.demo.inner.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import com.demo.utils.StringUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Component
public class ExampleUtil {
	
	public <E> Example getExample(E record){
		Example example = new Example(record.getClass());
		try {
			Criteria criteria = example.createCriteria();
			Class<?> c = record.getClass();
			Field []fields = c.getFields();
			for(Field field : fields){
				if(field.isAnnotationPresent(com.demo.base.entity.annotation.EnableExample.class)){
					Method m = getGetMethod(field.getName(),c);
					Object obj = m.invoke(record);
					if(obj.getClass() == String.class && StringUtil.isNotNull((String) obj)){
						criteria.andEqualTo(field.getName(),obj);
					}else if(null != obj.getClass()){
						criteria.andEqualTo(field.getName(),obj);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return example;
	}

	private Method getGetMethod(String name,Class<?> c) {
		Method method = null ;
		try {
			char ch = name.charAt(0);
			String methonName = "get"+Character.toUpperCase(ch)+name.substring(1);
			method = c.getMethod(methonName);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return method;
	}
	
}
