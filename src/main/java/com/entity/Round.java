package com.entity;
/**
* @author Administrator
* @date 2019年8月27日
* @version 1.0
*/
public class Round {
	private Integer id;//场次编号
	private String startTime;//开场时间
	private String endTime;//结束时间
	private String langType;//语言版本
	private String room;//放映厅
	private String seatStatus;//座位情况
	private Double orignPrice; //影院价
	private Double currentPrice;//现价
	private Integer movieId; //电影编号
	private Integer cinemaId;//影院编号
	public Round() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Round(Integer id, String startTime, String endTime, String langType, String room, String seatStatus,
			Double orignPrice, Double currentPrice, Integer movieId, Integer cinemaId) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.langType = langType;
		this.room = room;
		this.seatStatus = seatStatus;
		this.orignPrice = orignPrice;
		this.currentPrice = currentPrice;
		this.movieId = movieId;
		this.cinemaId = cinemaId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLangType() {
		return langType;
	}
	public void setLangType(String langType) {
		this.langType = langType;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}
	public Double getOrignPrice() {
		return orignPrice;
	}
	public void setOrignPrice(Double orignPrice) {
		this.orignPrice = orignPrice;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}
	
	
}
