package com.entity;
/**
* @author Administrator
* @date 2019��8��24��
* @version 1.0
*/
public class Area {     //����һ��������
	private Integer id;//������
	private String name;//��������
	private Integer cityId;//���б��--������������
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
