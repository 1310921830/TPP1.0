package com.entity;
/**
* @author Administrator
* @date 2019年8月24日
* @version 1.0
*/
public class Area {     //这是一个区域类
	private Integer id;//区域编号
	private String name;//区域名称
	private Integer cityId;//城市编号--用来关联城市
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Area(Integer id, String name, Integer cityId) {
		super();
		this.id = id;
		this.name = name;
		this.cityId = cityId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
}
