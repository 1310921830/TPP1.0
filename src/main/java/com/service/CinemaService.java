package com.service;

import java.util.List;

import org.springframework.ui.Model;

import com.entity.Cinema;

/**
* @author Administrator
* @date 2019年8月24日
* @version 1.0
*/

public interface CinemaService {
	
	/**
	 * @param model
	 * 初始化获取所有城市信息
	 */
	void getCities(Model model);
	
	/**
	 * @param model
	 * 从内存中获取所有城市信息
	 */
	void getHavingCities(Model model);
	
	/**
	 * @param id
	 * @param model
	 * 根据id选择城市
	 */
	void getCityById(Integer id,Model model);
	
	/**
	 * @param cityId
	 * @param model
	 * 根据城市获取指定数的影院，存到model中
	 */
	void getCinemasLimit(int cityId,Model model);
	
	/**
	 * @param cityId
	 * @return Cinema对象的集合
	 * 方法的重载，同样是根据城市获取指定数的影院，有返回值
	 */
	List<Cinema> getCinemasLimit(int cityId);
	
	/**
	 * @param cityId
	 * @param model
	 * 根据城市获取地区，存到model中
	 */
	void getAreasByCity(int cityId,Model model);
	
	/**
	 * @param cityId
	 * @param model
	 * 根据城市获取指定数的影院，存到model中
	 */
	void getCinemasByCity(int cityId,int movieId,Model model);
	
	
	/**
	 * @param id
	 * @param model
	 */
	void getCinemaById(int id,Model model);
}
