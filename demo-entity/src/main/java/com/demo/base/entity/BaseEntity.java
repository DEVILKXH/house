/**
 * @author kexiaohong
 * @version 1.0 2017年12月16日
 *
 */
package com.demo.base.entity;

import javax.persistence.Id;

public class BaseEntity {

	@Id
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		 this.id = id == null ? null : id.trim();
	}

}
