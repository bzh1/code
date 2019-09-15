package com.atguigu.movie.dao;

import com.atguigu.movie.bean.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {

    public Movie getNewMovie(Integer id){
        Movie movie = new Movie();
        movie.setId(id);
        movie.setMovieName("复仇者联盟");
        return movie;
    }
}
