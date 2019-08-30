package com.dao;

import com.entity.Order;

/**
* @author Administrator
* @date 2019年8月29日
* @version 1.0
*/
public interface OrderMapper {
	/**
	 * @param order
	 */
	void addOrder(Order order);
	/**
	 * @param id
	 * @return
	 */
	Order getOrderById(long id);
	/**
	 * @param id
	 */
	void updateOrderByPay(long id);
	
	/**
	 * @param id
	 * @return
	 * 查询是否付款
	 */
	Order queryOrderByPay(long id);
}
