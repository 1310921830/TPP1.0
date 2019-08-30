package com.dao;
/**
* @author Administrator
* @date 2019年8月20日
* @version 1.0
*/

import java.util.List;
import com.entity.Movie;

public interface MovieMapper {
    /**
     * @return Movie对象集合
                * 根据评分获取上映影片的前6名
     */
    List<Movie> getMoviesByScore();
    /**
     * @return Movie对象集合
               * 获取即将上映的影片前6
     */
    List<Movie> getMoviesFuLimit();
    /**
     * @param id
     * @return
     * 根据id获取影片
     */
    Movie getMovieById(int id);
}