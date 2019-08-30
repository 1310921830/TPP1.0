package com.dao;
/**
* @author Administrator
* @date 2019��8��20��
* @version 1.0
*/

import java.util.List;
import com.entity.Movie;

public interface MovieMapper {
    /**
     * @return Movie���󼯺�
                * �������ֻ�ȡ��ӳӰƬ��ǰ6��
     */
    List<Movie> getMoviesByScore();
    /**
     * @return Movie���󼯺�
               * ��ȡ������ӳ��ӰƬǰ6
     */
    List<Movie> getMoviesFuLimit();
    /**
     * @param id
     * @return
     * ����id��ȡӰƬ
     */
    Movie getMovieById(int id);
}