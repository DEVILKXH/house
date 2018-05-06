package com.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.base.entity.BaseEntity;

@Table(name = "house")
public class House extends BaseEntity{
    @Column(name = "origin")
	private String origin;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "brand")
    private String brand;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private Integer price;

    @Column(name = "type")
    private String type;
    
    @Column(name = "area")
    private int area;
    
    @Column(name = "createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}