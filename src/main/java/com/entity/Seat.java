package com.entity;
/**
* @author Administrator
* @date 2019年8月28日
* @version 1.0
*/
public class Seat {
	private Integer id;//座位编号
	private String name;//座位名称
	private Integer flag;//是否占座 0空1有
	private Integer roundId;//场次编号
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
