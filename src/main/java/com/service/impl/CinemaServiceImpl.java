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
* @date 2019年8月24日
* @version 1.0
*/
@Service
public class CinemaServiceImpl implements CinemaService{
	@Autowired
	CinemaMapper cm;//调用dao层的影院接口
	@Autowired
	RoundMapper rm;//调用dao层的场次接口
	private List<City> allCity = null;//用来存储所有城市信息
	private Map<Integer, Cinema> cinemaMap=new HashMap<Integer, Cinema>();//储存影院
	
	
	/**
	 * @param cityId
	 * @param model
	 * @see cm接口的getCinemasLimit方法
	 * 根据城市获取指定数的影院，存到model中
	 */
	@Override
	public void getCinemasLimit(int cityId,Model model) {
		List<Cinema> cinemas = cm.getCinemasLimit(cityId);
		model.addAttribute("cinemasLimit", cinemas);
	}
	
	/**
	 * @param cityId
	 * @return Cinema对象的集合
	 * @see cm接口的getCinemasLimit方法
	 * 方法的重载，同样是根据城市获取指定数的影院
	 */
	@Override
	public List<Cinema> getCinemasLimit(int cityId) {
		List<Cinema> cinemas = cm.getCinemasLimit(cityId);
		return cinemas;
	}
	
	/**
	 * @param model
	 * @see cm接口的getCities方法
	 * 初始化获取所有城市信息
	 */
	@Override
	public void getCities(Model model) {
		List<City> cities = cm.getCities();
		this.allCity = cities;//把城市信息存到内存中，下次可以直接调用，不需要dao层访问
		model.addAttribute("cities", cities);
	}
	
	
	/**
	 * @param id
	 * @param model
	 * @see cm接口的getCity方法
	 * 根据id选择城市
	 */
	@Override
	public void getCityById(Integer id,Model model) {
		City city =cm.getCity(id);
		model.addAttribute("city", city);
	}

	/**
	 * @param model
	 * 从内存中获取所有城市信息
	 */
	@Override
	public void getHavingCities(Model model) {
		if(null!=this.allCity) {
		//直接从内存中加载所有城市
		model.addAttribute("cities", this.allCity);
		}else {
			getCities(model);
		}
	}
	
	/**
	 * @param cityId
	 * @param model
	 * @see cm接口的getAreasByCity方法
	 * 根据城市获取地区，存到model中
	 */
	@Override
	public void getAreasByCity(int cityId, Model model) {
		List<Area> areas = cm.getAreasByCity(cityId);
		model.addAttribute("areas", areas);
	}
	
	/**
	 * @param cityId
	 * @param model
	 * @see cm接口的getCinemasByCity方法
	 * 根据城市获取所有影院，存到model中
	 * 同时默认加载第一家影院的影片场次信息
	 */
	@Override
	public void getCinemasByCity(int cityId,int movieId, Model model) {
		List<Cinema> cinemas = cm.getCinemasByCity(cityId);
		//放入内存
		for(Cinema c:cinemas) {
			this.cinemaMap.put(c.getId(), c);
		}
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("cinemaSelect", cinemas.get(0));
		int cinemaId = cinemas.get(0).getId();//首家影院id
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("movieId", movieId);
		map.put("cinemaId", cinemaId);
		Date date = new Date();
		map.put("date", DateUtil.dateString1(date));//默认当天
		model.addAttribute("rounds", rm.getRounds(map));
		
	}
	
	/**
	 * @param id
	 * @param model
	 * @see cm接口的getCinemaById方法
	 * 先从内存中读取，没有从数据库获取
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
