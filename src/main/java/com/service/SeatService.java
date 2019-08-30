package com.service;

import org.springframework.ui.Model;

/**
* @author Administrator
* @date 2019��8��28��
* @version 1.0
*/
public interface SeatService {
	/**
	 * @param roundId
	 * @param model
	 * ������λ
	 */
	void getSeats(int roundId,Model model);
	/**
	 * @param strIds
	 * @return
	 * ����һϵ����λid��֤�Ƿ���ռ�����
	 */
	int querySeats(String strIds);
	
	/**
	 * @param strIds
	 * @param model
	 * �û�ѡ�õ���λ
	 */
	void getSeats(String strIds,Model model);
	
	/**
	 * @param strIds
	 * @return
	 * �ͷ���λ
	 */
	int seatsBack(String strIds);
}
