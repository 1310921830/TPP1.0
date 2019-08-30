package com.service;

import java.util.Map;
import com.entity.Order;

/**
* @author Administrator
* @date 2019��8��29��
* @version 1.0
*/
public interface OrderService {
	/**
	 * @param map
	 * @return������
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
