package com.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import com.util.Md5Util;

/**
* @author Administrator
* @date 2019年8月26日
* @version 1.0
*/

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserMapper um;//调用dao层的用户接口
	
	/**
	 * @param user
	 * @return 影响条数
	 * @see um接口的saveUser方法
	 * 用户注册
	 */
	@Override
	public int saveUser(Map<String, String> map) {
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		String nickname = map.get("nickname");
		
		String tel = map.get("tel");
		String password=null;
		try {
			password = Md5Util.encrypt(map.get("password"));//加密
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = map.get("name");
		User user = new User(id, nickname, tel, password, name);
		
		return um.saveUser(user);
	}
	
	/**
	 * @param map
	 * @return User对象
	 * @see um接口的getUser方法
	 * 用户登录
	 */
	@Override
	public User getUser(Map<String, String> map) {
		String password=null;
		try {
			password = Md5Util.encrypt(map.get("password"));//加密
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("password",password);
		return um.getUser(map);
	}

}
