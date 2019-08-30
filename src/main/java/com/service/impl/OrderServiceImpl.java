package com.service.impl;


import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.OrderMapper;
import com.dao.SeatMapper;
import com.entity.Order;
import com.service.OrderService;
import com.util.DateUtil;

/**
* @author Administrator
* @date 2019年8月29日
* @version 1.0
*/
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderMapper om;
	@Autowired
	SeatMapper sm;
	
	/**
	 * @param map
	 */
	@Override
	public long addOrder(Map<String, String> map) {
		long id = getId();
		String seatInfo = map.get("strIds");
		Double sumPrice = Double.parseDouble(map.get("sumPrice"));
		String orderNumb = getCode();
		String identifyCode = getCode();
		String isPay = "否";
		String tel = map.get("tel");
		String orderTime = DateUtil.dateString1(new Date());
		String userId = map.get("uId");
		int roundId = Integer.parseInt(map.get("rId"));
		Order order = new Order(id, seatInfo, sumPrice, orderNumb, identifyCode, isPay, tel, orderTime, userId, roundId);
		om.addOrder(order);
		//同时15分钟后验证是否付款，没付款就是否座位
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				//没有付款的话
				if(null==om.queryOrderByPay(id)) {
					String[] temp =seatInfo.split(",");
					for(String strId:temp) {
						sm.seatBack(new Integer(strId));
					}
					System.out.println("座位已释放");
				}else {
					System.out.println("已经付款");
				}
				
				
			}
		};
		timer.schedule(task, 900000);
		return id;
	}
	
	/**
	 * @param id
	 * @param model
	 */
	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		Order order = om.getOrderById(id);
		
		return order;
	}
	//随机产生订单号
	public long getId() {
		Date date = new Date();
		return date.getTime();
	}
	//产生取票号、或验证码6位数字
	public String getCode() {
		String str = "";
		for(int i=0;i<6;i++) {
			int n = (int)(Math.random()*10);
			str = str + n;
		}
		return str;
	}
	/**
	 * @param id
	 */
	@Override
	public void updateOrderByPay(long id) {
		// TODO Auto-generated method stub
		om.updateOrderByPay(id);
	}
}
