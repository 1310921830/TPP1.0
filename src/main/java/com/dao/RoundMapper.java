package com.dao;
/**
* @author Administrator
* @date 2019��8��27��
* @version 1.0
*/

import java.util.List;
import java.util.Map;

import com.entity.Round;

public interface RoundMapper {
	/**
	 * @param map
	 * @return ���μ���
	 * ����map���Ӱid��ӰԺid��ʱ���ȡ������Ϣ
	 */
	List<Round> getRounds(Map<String, Object> map);
	/**
	 * @param id
	 * @return ����
	 */
	Round getRoundById(int id);
}
