package com.service;

import java.util.Map;

import com.entity.User;

/**
* @author Administrator
* @date 2019��8��26��
* @version 1.0
*/
public interface UserService {
	/**
	 * @param map
	 * @return Ӱ������
	 * �û�ע��
	 */
	int saveUser(Map<String, String> map);
	/**
	 * @param map
	 * @return User����
	 * �û���¼
	 */
	User getUser(Map<String, String> map);
}
