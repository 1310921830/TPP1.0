package com.service;


import org.springframework.ui.Model;


/**
* @author Administrator
* @date 2019��8��24��
* @version 1.0
*/
public interface MovieService {
	/**
	 * @param model
	 * �������ֻ�ȡ��ӳӰƬ��ǰ6��
	 */
	void getMoviesByScore(Model model);
	/**
	 * @param model
	 * ��ȡ������ӳ��ӰƬǰ6
	 */
	void getMoviesFuLimit(Model model);
	/**
	 * @param model
	 * ����id��ȡӰƬ
	 */
	void getMovieById(int id,Model model);
}
