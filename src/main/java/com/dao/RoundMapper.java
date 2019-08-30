package com.dao;
/**
* @author Administrator
* @date 2019年8月27日
* @version 1.0
*/

import java.util.List;
import java.util.Map;

import com.entity.Round;

public interface RoundMapper {
	/**
	 * @param map
	 * @return 场次集合
	 * 根据map里电影id、影院id、时间获取场次信息
	 */
	List<Round> getRounds(Map<String, Object> map);
	/**
	 * @param id
	 * @return 场次
	 */
	Round getRoundById(int id);
}
