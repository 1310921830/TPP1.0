package com.service;

import java.util.List;
import java.util.Map;
import com.entity.Round;

/**
* @author Administrator
* @date 2019年8月27日
* @version 1.0
*/
public interface RoundService {
	
	/**
	 * @param map
	 * @return 场次集合
	 * 根据map里电影id、影院id、时间获取场次信息
	 */
	List<Round> getRounds(Map<String, Object> map);
	/**
	 * @param id
	 * @return
	 */
	Round getRoundById(int id);
}
