package com.dao;
/**
* @author Administrator
* @date 2019年8月28日
* @version 1.0
*/

import java.util.List;

import com.entity.Seat;

public interface SeatMapper {
	/**
	 * @param roundId
	 * @return 座位集合
	 * 根据场次获取座位信息
	 */
	List<Seat> getSeats(int roundId);
	/**
	 * @param id
	 * @return
	 */
	Seat getSeatById(int id);
	/**
	 * @param id
	 * @return
	 */
	Seat querySeatById(int id);
	/**
	 * @param id
	 * 占座
	 */
	void updateSeat(int id);
	
	/**
	 * @param id
	 * 释放座位
	 */
	int seatBack(int id);
}
