package com.entity;
/**
* @author Administrator
* @date 2019年8月24日
* @version 1.0
*/
public class Cinema {//这是一个影院类
	private Integer id;//影院编号
	private String name;//影院名称
	private Double score;//影院评分
	private String tel;//影院联系电话
	private String site;//影院地址
	private String siteImg;//地址图片
	private Integer areaId;//所属的地区编号
	public Cinema(Integer id, String name, Double score, String tel, String site, String siteImg, Integer areaId) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.tel = tel;
		this.site = site;
		this.siteImg = siteImg;
		this.areaId = areaId;
	}
	public Cinema() {
		super();
		// TODO Auto-generated constructor stub
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
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSiteImg() {
		return siteImg;
	}
	public void setSiteImg(String siteImg) {
		this.siteImg = siteImg;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
}
