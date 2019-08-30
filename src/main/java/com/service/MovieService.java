package com.service;


import org.springframework.ui.Model;


/**
* @author Administrator
* @date 2019年8月24日
* @version 1.0
*/
public interface MovieService {
	/**
	 * @param model
	 * 根据评分获取上映影片的前6名
	 */
	void getMoviesByScore(Model model);
	/**
	 * @param model
	 * 获取即将上映的影片前6
	 */
	void getMoviesFuLimit(Model model);
	/**
	 * @param model
	 * 根据id获取影片
	 */
	void getMovieById(int id,Model model);
}
