package com.dao;

import java.util.Map;

import com.entity.User;

/**
* @author Administrator
* @date 2019��8��26��
* @version 1.0
*/
public interface UserMapper {
	/**
	 * @param user
	 * @return Ӱ������
	 * �û�ע��
	 */
	int saveUser(User user);
	/**
	 * @param map
	 * @return User����
	 * �û���¼
	 */
	User getUser(Map<String, String> map);
}
