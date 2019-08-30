package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.dao.SeatMapper;
import com.entity.Seat;
import com.service.SeatService;

/**
* @author Administrator
* @date 2019年8月28日
* @version 1.0
*/
@Service
public class SeatServiceImpl implements SeatService{
	@Autowired
	SeatMapper sm;//dao层座位接口
	
	/**
	 * @param roundId
	 * @param model
	 * @see sm的getSeats方法
	 */
	@Override
	public void getSeats(int roundId, Model model) {
		model.addAttribute("seats", sm.getSeats(roundId));
		
	}
	
	/**
	 * @param strIds
	 * @return
	 * 根据一系列座位id验证是否有占座情况
	 * 无占座，直接占座
	 */
	@Override
	public int querySeats(String strIds) {
		String[] temp =strIds.split(",");
		int result = 1;
		for(String strId:temp) {
			if(null==sm.querySeatById(new Integer(strId))) {
				result=0;
				break;
			}
		}
		if(result==1) {
			for(String strId:temp) {
				sm.updateSeat(new Integer(strId));
			}
		}
		return result;
	}
	/**
	 * @param strIds
	 * @param model
	 * 用户选好的坐位
	 */
	@Override
	public void getSeats(String strIds, Model model) {
		String[] temp =strIds.split(",");
		List<Seat> seats = new ArrayList<Seat>();
		for(String strId:temp) {
			seats.add(sm.getSeatById(new Integer(strId)));
		}
		model.addAttribute("selectSeats", seats);
	}
	/**
	 * @param strIds
	 * @return
	 * 释放座位
	 */
	@Override
	public int seatsBack(String strIds) {
		String[] temp =strIds.split(",");
		int result = 0;
		for(String strId:temp) {
			int n = sm.seatBack(new Integer(strId));
			result = result +n;
		}
		return result;
	}

}
