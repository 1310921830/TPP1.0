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
* @date 2019��8��24��
* @version 1.0
*/
@Service
public class MoveServiceImpl implements MovieService{
	@Autowired
	MovieMapper mm;//����dao���ӰƬ�ӿ�
	private Map<Integer, Movie> movieMap=new HashMap<Integer, Movie>();//�����Ӱ
	
	/**
	 * @param model
	 * @see mm�ӿڵ�getMoviesByScore����
	 * �������ֻ�ȡ��ӳӰƬ��ǰ6��
	 */
	@Override
	public void getMoviesByScore(Model model) {
		List<Movie> moviesNowLimit = mm.getMoviesByScore();
		for(Movie m:moviesNowLimit) {//�����ڴ�
			this.movieMap.put(m.getId(), m);
		}
		model.addAttribute("moviesNowLimit", moviesNowLimit);
	}
	
	/**
	 * @param model
	 * @see mm�ӿڵ�getMoviesFuLimit����
	 * ��ȡ������ӳ��ӰƬǰ6
	 */
	@Override
	public void getMoviesFuLimit(Model model) {
		List<Movie> moviesFuLimit = mm.getMoviesFuLimit();
		for(Movie m:moviesFuLimit) {//�����ڴ�
			this.movieMap.put(m.getId(), m);
		}
		model.addAttribute("moviesFuLimit", moviesFuLimit);
	}
	
	/**
	 * @param model
	 * ����id��ȡӰƬ���ȴ��ڴ��ж�ȡ��û�д����ݿ��ȡ
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
