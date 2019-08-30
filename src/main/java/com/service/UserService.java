package com.service;

import java.util.Map;

import com.entity.User;

/**
* @author Administrator
* @date 2019年8月26日
* @version 1.0
*/
public interface UserService {
	/**
	 * @param map
	 * @return 影响条数
	 * 用户注册
	 */
	int saveUser(Map<String, String> map);
	/**
	 * @param map
	 * @return User对象
	 * 用户登录
	 */
	User getUser(Map<String, String> map);
}
