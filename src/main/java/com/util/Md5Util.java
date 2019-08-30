package com.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
* @author Administrator
* @date 2019年8月26日
* @version 1.0
*/
public class Md5Util {
	
	public static String encrypt(String str) throws UnsupportedEncodingException {
		byte[] data = str.getBytes("utf-8");
		//获取消息摘要对象
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//把数据更新入对象中，只接受byte数组
		md5.update(data);	
		//加密结果
		byte[] result = md5.digest(); //16个byte
		
		//转换为16进制字符串
		String newStr = new BigInteger(1, result).toString(16);
		return newStr;
	}
}
