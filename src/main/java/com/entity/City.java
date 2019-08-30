package com.entity;
/**
* @author Administrator
* @date 2019年8月24日
* @version 1.0
*/
public class City {   //这是一个城市类
	private Integer id;//城市编号
	private String name;//城市名称
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
