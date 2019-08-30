package com.dao;
/**
* @author Administrator
* @date 2019��8��24��
* @version 1.0
*/

import java.util.List;

import com.entity.Area;
import com.entity.Cinema;
import com.entity.City;

public interface CinemaMapper {
	
	/**
	 * @param cityId
	 * @return Cinema����ļ���
	   * ���ݳ��л�ȡǰ6λ��ӰԺ
	 */
	List<Cinema> getCinemasLimit(int cityId);
	
	/**
	 * @param cityId
	 * @return Cinema����ļ���
	   * ���ݳ��л�ȡ����ӰԺ
	 */
	List<Cinema> getCinemasByCity(int cityId);
	/**
	 * @return City����ļ���
	   * ��ȡ���г��е���Ϣ
	 */
	List<City> getCities();
	/**
	 * @param id
	 * @return City����
	    * ����id��ȡ����
	 */
	City getCity(int id);
	
	/**
	 * @param cityId
	 * @return Area����ļ���
	    * ���ݳ���id��ȡ���е���
	 */
	List<Area> getAreasByCity(int cityId);
	
	/**
	 * @param id
	 * @return
	 */
	Cinema getCinemaById(int id);
}
