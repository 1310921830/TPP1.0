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
* @date 2019��8��26��
* @version 1.0
*/

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserMapper um;//����dao����û��ӿ�
	
	/**
	 * @param user
	 * @return Ӱ������
	 * @see um�ӿڵ�saveUser����
	 * �û�ע��
	 */
	@Override
	public int saveUser(Map<String, String> map) {
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		String nickname = map.get("nickname");
		
		String tel = map.get("tel");
		String password=null;
		try {
			password = Md5Util.encrypt(map.get("password"));//����
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
	 * @return User����
	 * @see um�ӿڵ�getUser����
	 * �û���¼
	 */
	@Override
	public User getUser(Map<String, String> map) {
		String password=null;
		try {
			password = Md5Util.encrypt(map.get("password"));//����
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("password",password);
		return um.getUser(map);
	}

}
