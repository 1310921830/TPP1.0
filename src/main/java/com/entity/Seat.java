package com.entity;
/**
* @author Administrator
* @date 2019��8��28��
* @version 1.0
*/
public class Seat {
	private Integer id;//��λ���
	private String name;//��λ����
	private Integer flag;//�Ƿ�ռ�� 0��1��
	private Integer roundId;//���α��
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seat(Integer id, String name, Integer flag, Integer roundId) {
		super();
		this.id = id;
		this.name = name;
		this.flag = flag;
		this.roundId = roundId;
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getRoundId() {
		return roundId;
	}
	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}
	
}
