package com.service;

import org.springframework.ui.Model;

/**
* @author Administrator
* @date 2019年8月28日
* @version 1.0
*/
public interface SeatService {
	/**
	 * @param roundId
	 * @param model
	 * 所有座位
	 */
	void getSeats(int roundId,Model model);
	/**
	 * @param strIds
	 * @return
	 * 根据一系列座位id验证是否有占座情况
	 */
	int querySeats(String strIds);
	
	/**
	 * @param strIds
	 * @param model
	 * 用户选好的坐位
	 */
	void getSeats(String strIds,Model model);
	
	/**
	 * @param strIds
	 * @return
	 * 释放座位
	 */
	int seatsBack(String strIds);
}
