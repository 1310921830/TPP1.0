package com.service;

import java.util.Map;
import com.entity.Order;

/**
* @author Administrator
* @date 2019年8月29日
* @version 1.0
*/
public interface OrderService {
	/**
	 * @param map
	 * @return订单号
	 */
	long addOrder(Map<String, String> map);
	/**
	 * @param id
	 * @param model
	 */
	Order getOrderById(long id);
	/**
	 * @param id
	 */
	void updateOrderByPay(long id);
}
