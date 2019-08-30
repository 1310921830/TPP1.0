package com.entity;



/**
* @author Administrator
* @date 2019年8月29日
* @version 1.0
*/
public class Order {
	private long id;//订单号
	private String seatInfo;//座位信息
	private Double sumPrice;//总价
	private String orderNumb;//取票号
	private String identifyCode;//验证码
	private String isPay;//是否支付
	private String tel;//接受短信的手机号
	private String orderTime;//下单时间
	private String userId;//用户id
	private Integer roundId;//场次id
	public Order(long id, String seatInfo, Double sumPrice, String orderNumb, String identifyCode, String isPay,
			String tel, String orderTime, String userId, Integer roundId) {
		super();
		this.id = id;
		this.seatInfo = seatInfo;
		this.sumPrice = sumPrice;
		this.orderNumb = orderNumb;
		this.identifyCode = identifyCode;
		this.isPay = isPay;
		this.tel = tel;
		this.orderTime = orderTime;
		this.userId = userId;
		this.roundId = roundId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSeatInfo() {
		return seatInfo;
	}
	public void setSeatInfo(String seatInfo) {
		this.seatInfo = seatInfo;
	}
	public Double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getOrderNumb() {
		return orderNumb;
	}
	public void setOrderNumb(String orderNumb) {
		this.orderNumb = orderNumb;
	}
	public String getIdentifyCode() {
		return identifyCode;
	}
	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getRoundId() {
		return roundId;
	}
	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}
	
}
