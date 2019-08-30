package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.dao.MovieMapper;
import com.entity.Movie;
import com.service.MovieService;


/**
* @author Administrator
* @date 2019年8月24日
* @version 1.0
*/
@Service
public class MoveServiceImpl implements MovieService{
	@Autowired
	MovieMapper mm;//调用dao层的影片接口
	private Map<Integer, Movie> movieMap=new HashMap<Integer, Movie>();//储存电影
	
	/**
	 * @param model
	 * @see mm接口的getMoviesByScore方法
	 * 根据评分获取上映影片的前6名
	 */
	@Override
	public void getMoviesByScore(Model model) {
		List<Movie> moviesNowLimit = mm.getMoviesByScore();
		for(Movie m:moviesNowLimit) {//放入内存
			this.movieMap.put(m.getId(), m);
		}
		model.addAttribute("moviesNowLimit", moviesNowLimit);
	}
	
	/**
	 * @param model
	 * @see mm接口的getMoviesFuLimit方法
	 * 获取即将上映的影片前6
	 */
	@Override
	public void getMoviesFuLimit(Model model) {
		List<Movie> moviesFuLimit = mm.getMoviesFuLimit();
		for(Movie m:moviesFuLimit) {//放入内存
			this.movieMap.put(m.getId(), m);
		}
		model.addAttribute("moviesFuLimit", moviesFuLimit);
	}
	
	/**
	 * @param model
	 * 根据id获取影片，先从内存中读取，没有从数据库获取
	 */
	@Override
	public void getMovieById(int id,Model model) {
		Movie movie = this.movieMap.get(id);
		if(null==movie) {
			movie = mm.getMovieById(id);
		}
		model.addAttribute("movie", movie);
	}
	

}
