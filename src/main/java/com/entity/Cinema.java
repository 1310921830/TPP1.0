package com.entity;
/**
* @author Administrator
* @date 2019��8��24��
* @version 1.0
*/
public class Cinema {//����һ��ӰԺ��
	private Integer id;//ӰԺ���
	private String name;//ӰԺ����
	private Double score;//ӰԺ����
	private String tel;//ӰԺ��ϵ�绰
	private String site;//ӰԺ��ַ
	private String siteImg;//��ַͼƬ
	private Integer areaId;//�����ĵ������
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
