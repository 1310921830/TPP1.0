package com.dao;

import java.util.Map;

import com.entity.User;

/**
* @author Administrator
* @date 2019年8月26日
* @version 1.0
*/
public interface UserMapper {
	/**
	 * @param user
	 * @return 影响条数
	 * 用户注册
	 */
	int saveUser(User user);
	/**
	 * @param map
	 * @return User对象
	 * 用户登录
	 */
	User getUser(Map<String, String> map);
}
