package com.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.dao.CinemaMapper;
import com.dao.RoundMapper;
import com.entity.Area;
import com.entity.Cinema;
import com.entity.City;
import com.service.CinemaService;
import com.util.DateUtil;

/**
* @author Administrator
* @date 2019��8��24��
* @version 1.0
*/
@Service
public class CinemaServiceImpl implements CinemaService{
	@Autowired
	CinemaMapper cm;//����dao���ӰԺ�ӿ�
	@Autowired
	RoundMapper rm;//����dao��ĳ��νӿ�
	private List<City> allCity = null;//�����洢���г�����Ϣ
	private Map<Integer, Cinema> cinemaMap=new HashMap<Integer, Cinema>();//����ӰԺ
	
	
	/**
	 * @param cityId
	 * @param model
	 * @see cm�ӿڵ�getCinemasLimit����
	 * ���ݳ��л�ȡָ������ӰԺ���浽model��
	 */
	@Override
	public void getCinemasLimit(int cityId,Model model) {
		List<Cinema> cinemas = cm.getCinemasLimit(cityId);
		model.addAttribute("cinemasLimit", cinemas);
	}
	
	/**
	 * @param cityId
	 * @return Cinema����ļ���
	 * @see cm�ӿڵ�getCinemasLimit����
	 * ���������أ�ͬ���Ǹ��ݳ��л�ȡָ������ӰԺ
	 */
	@Override
	public List<Cinema> getCinemasLimit(int cityId) {
		List<Cinema> cinemas = cm.getCinemasLimit(cityId);
		return cinemas;
	}
	
	/**
	 * @param model
	 * @see cm�ӿڵ�getCities����
	 * ��ʼ����ȡ���г�����Ϣ
	 */
	@Override
	public void getCities(Model model) {
		List<City> cities = cm.getCities();
		this.allCity = cities;//�ѳ�����Ϣ�浽�ڴ��У��´ο���ֱ�ӵ��ã�����Ҫdao�����
		model.addAttribute("cities", cities);
	}
	
	
	/**
	 * @param id
	 * @param model
	 * @see cm�ӿڵ�getCity����
	 * ����idѡ�����
	 */
	@Override
	public void getCityById(Integer id,Model model) {
		City city =cm.getCity(id);
		model.addAttribute("city", city);
	}

	/**
	 * @param model
	 * ���ڴ��л�ȡ���г�����Ϣ
	 */
	@Override
	public void getHavingCities(Model model) {
		if(null!=this.allCity) {
		//ֱ�Ӵ��ڴ��м������г���
		model.addAttribute("cities", this.allCity);
		}else {
			getCities(model);
		}
	}
	
	/**
	 * @param cityId
	 * @param model
	 * @see cm�ӿڵ�getAreasByCity����
	 * ���ݳ��л�ȡ�������浽model��
	 */
	@Override
	public void getAreasByCity(int cityId, Model model) {
		List<Area> areas = cm.getAreasByCity(cityId);
		model.addAttribute("areas", areas);
	}
	
	/**
	 * @param cityId
	 * @param model
	 * @see cm�ӿڵ�getCinemasByCity����
	 * ���ݳ��л�ȡ����ӰԺ���浽model��
	 * ͬʱĬ�ϼ��ص�һ��ӰԺ��ӰƬ������Ϣ
	 */
	@Override
	public void getCinemasByCity(int cityId,int movieId, Model model) {
		List<Cinema> cinemas = cm.getCinemasByCity(cityId);
		//�����ڴ�
		for(Cinema c:cinemas) {
			this.cinemaMap.put(c.getId(), c);
		}
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("cinemaSelect", cinemas.get(0));
		int cinemaId = cinemas.get(0).getId();//�׼�ӰԺid
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("movieId", movieId);
		map.put("cinemaId", cinemaId);
		Date date = new Date();
		map.put("date", DateUtil.dateString1(date));//Ĭ�ϵ���
		model.addAttribute("rounds", rm.getRounds(map));
		
	}
	
	/**
	 * @param id
	 * @param model
	 * @see cm�ӿڵ�getCinemaById����
	 * �ȴ��ڴ��ж�ȡ��û�д����ݿ��ȡ
	 */
	@Override
	public void getCinemaById(int id, Model model) {
		Cinema cinema = this.cinemaMap.get(id);
		if(null==cinema) {
			cinema=cm.getCinemaById(id);
		}
		model.addAttribute("cinema", cinema);
		
	}

}
