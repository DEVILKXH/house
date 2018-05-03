package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Table;

import com.demo.base.entity.BaseEntity;

@Table(name = "user")
public class User extends BaseEntity{

	@Column(name = "username")
    private String username;

	@Column(name = "phone")
    private String phone;

	
	public User(String id) {
		this.id = id;
	}
	
	public User(String username,String phone) {
		this.username = username;
		this.phone = phone;
	}
	
	public User(String id,String username,String phone) {
		this.id = id;
		this.username = username;
		this.phone = phone;
	}
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}