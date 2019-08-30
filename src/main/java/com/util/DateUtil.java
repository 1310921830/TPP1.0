package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;// 格式类
import java.util.Date;//日期类

//日期对象与字符串的相互转换
//格式一
public class DateUtil {
	// Date对象转字符串 “yyyy-MM-dd hh:mm:ss”
	public static String dateString1(Date date) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = null;
		if (date != null) {
			str = s.format(date);

		}
		return str;
	}
//格式二
	public static String dateString2(Date date) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
		String str = null;
		if (date != null) {
			str = s.format(date);

		}
		return str;
	}
	//字符串转Date对象
	//抓取异常，防止模式不匹配
	
	public static Date stringToDate(String str) {
		Date date =null;
		SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
		try{
		date = s.parse(str);}
		catch(ParseException e){
			e.printStackTrace();
		}
		return date;
		
	}
	
}
