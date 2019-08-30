package com.dao;
/**
* @author Administrator
* @date 2019年8月24日
* @version 1.0
*/

import java.util.List;

import com.entity.Area;
import com.entity.Cinema;
import com.entity.City;

public interface CinemaMapper {
	
	/**
	 * @param cityId
	 * @return Cinema对象的集合
	   * 根据城市获取前6位的影院
	 */
	List<Cinema> getCinemasLimit(int cityId);
	
	/**
	 * @param cityId
	 * @return Cinema对象的集合
	   * 根据城市获取所有影院
	 */
	List<Cinema> getCinemasByCity(int cityId);
	/**
	 * @return City对象的集合
	   * 获取所有城市的信息
	 */
	List<City> getCities();
	/**
	 * @param id
	 * @return City对象
	    * 根据id获取城市
	 */
	City getCity(int id);
	
	/**
	 * @param cityId
	 * @return Area对象的集合
	    * 根据城市id获取所有地区
	 */
	List<Area> getAreasByCity(int cityId);
	
	/**
	 * @param id
	 * @return
	 */
	Cinema getCinemaById(int id);
}
