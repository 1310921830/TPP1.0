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
* @date 2019��8��29��
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
		String isPay = "��";
		String tel = map.get("tel");
		String orderTime = DateUtil.dateString1(new Date());
		String userId = map.get("uId");
		int roundId = Integer.parseInt(map.get("rId"));
		Order order = new Order(id, seatInfo, sumPrice, orderNumb, identifyCode, isPay, tel, orderTime, userId, roundId);
		om.addOrder(order);
		//ͬʱ15���Ӻ���֤�Ƿ񸶿û������Ƿ���λ
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				//û�и���Ļ�
				if(null==om.queryOrderByPay(id)) {
					String[] temp =seatInfo.split(",");
					for(String strId:temp) {
						sm.seatBack(new Integer(strId));
					}
					System.out.println("��λ���ͷ�");
				}else {
					System.out.println("�Ѿ�����");
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
	//�������������
	public long getId() {
		Date date = new Date();
		return date.getTime();
	}
	//����ȡƱ�š�����֤��6λ����
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
