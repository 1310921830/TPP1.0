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
* @date 2019��8��27��
* @version 1.0
*/
@Service
public class RoundServiceImpl implements RoundService{
	private Map<Integer, Round> roundMap =new HashMap<Integer, Round>();
	@Autowired RoundMapper rm;//����dao�㳡�νӿ�
	
	
	/**
	 * @param map
	 * @param model
	 * @see rm�ӿڵ�getRounds����
	 * ����map���Ӱid��ӰԺid��ʱ���ȡ������Ϣ
	 */
	@Override
	public List<Round> getRounds(Map<String, Object> map) {
		List<Round> rounds = rm.getRounds(map);
		//�����ڴ�
		for(Round r:rounds) {
			this.roundMap.put(r.getId(), r);
		}
		return rounds;
	}

	/**
	 * @param id
	 * @return ����
	 * �ȿ��ڴ���û�У�û�з������ݿ�
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
