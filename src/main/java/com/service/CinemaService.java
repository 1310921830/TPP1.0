package com.service;

import java.util.List;

import org.springframework.ui.Model;

import com.entity.Cinema;

/**
* @author Administrator
* @date 2019��8��24��
* @version 1.0
*/

public interface CinemaService {
	
	/**
	 * @param model
	 * ��ʼ����ȡ���г�����Ϣ
	 */
	void getCities(Model model);
	
	/**
	 * @param model
	 * ���ڴ��л�ȡ���г�����Ϣ
	 */
	void getHavingCities(Model model);
	
	/**
	 * @param id
	 * @param model
	 * ����idѡ�����
	 */
	void getCityById(Integer id,Model model);
	
	/**
	 * @param cityId
	 * @param model
	 * ���ݳ��л�ȡָ������ӰԺ���浽model��
	 */
	void getCinemasLimit(int cityId,Model model);
	
	/**
	 * @param cityId
	 * @return Cinema����ļ���
	 * ���������أ�ͬ���Ǹ��ݳ��л�ȡָ������ӰԺ���з���ֵ
	 */
	List<Cinema> getCinemasLimit(int cityId);
	
	/**
	 * @param cityId
	 * @param model
	 * ���ݳ��л�ȡ�������浽model��
	 */
	void getAreasByCity(int cityId,Model model);
	
	/**
	 * @param cityId
	 * @param model
	 * ���ݳ��л�ȡָ������ӰԺ���浽model��
	 */
	void getCinemasByCity(int cityId,int movieId,Model model);
	
	
	/**
	 * @param id
	 * @param model
	 */
	void getCinemaById(int id,Model model);
}
