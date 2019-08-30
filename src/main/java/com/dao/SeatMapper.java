package com.dao;
/**
* @author Administrator
* @date 2019��8��28��
* @version 1.0
*/

import java.util.List;

import com.entity.Seat;

public interface SeatMapper {
	/**
	 * @param roundId
	 * @return ��λ����
	 * ���ݳ��λ�ȡ��λ��Ϣ
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
	 * ռ��
	 */
	void updateSeat(int id);
	
	/**
	 * @param id
	 * �ͷ���λ
	 */
	int seatBack(int id);
}
