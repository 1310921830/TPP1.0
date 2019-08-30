package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.RoundMapper;
import com.entity.Round;
import com.service.RoundService;

/**
* @author Administrator
* @date 2019年8月27日
* @version 1.0
*/
@Service
public class RoundServiceImpl implements RoundService{
	private Map<Integer, Round> roundMap =new HashMap<Integer, Round>();
	@Autowired RoundMapper rm;//调用dao层场次接口
	
	
	/**
	 * @param map
	 * @param model
	 * @see rm接口的getRounds方法
	 * 根据map里电影id、影院id、时间获取场次信息
	 */
	@Override
	public List<Round> getRounds(Map<String, Object> map) {
		List<Round> rounds = rm.getRounds(map);
		//放入内存
		for(Round r:rounds) {
			this.roundMap.put(r.getId(), r);
		}
		return rounds;
	}

	/**
	 * @param id
	 * @return 场次
	 * 先看内存有没有，没有访问数据库
	 */
	@Override
	public Round getRoundById(int id) {
		Round round = this.roundMap.get(id);
		if(null==round) {
			round=rm.getRoundById(id);
		}
		return round;
	}

	

}
