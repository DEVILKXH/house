package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Table;

import com.demo.base.entity.BaseEntity;
import com.demo.base.entity.annotation.EnableExample;

@Table(name = "house2")
public class House2 extends BaseEntity{

	@Column(name = "city")
	@EnableExample
    private String city;

	@Column(name = "area")
	@EnableExample
    private String area;

	@Column(name = "year")
	@EnableExample
    private String year;

	@Column(name = "price")
	@EnableExample
    private String price;

	@Column(name = "month")
	@EnableExample
    private String month;

	@Column(name = "origin")
	@EnableExample
    private String origin;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
    	String area = this.area;
    	switch (this.area) {
		case "siming":
			area = "思明";
			break;
		case "huli":
			area = "湖里";
			break;
		case "xiangana":
			area = "翔安";
			break;
		case "haicang":
			area = "海沧";
			break;
		case "tongana":
			area = "同安";
			break;
		case "jimei":
			area = "集美";
			break;
		default:
			break;
		}
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }
}