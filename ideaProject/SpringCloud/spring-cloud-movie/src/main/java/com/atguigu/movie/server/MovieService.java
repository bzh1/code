package com.atguigu.movie.server;

import com.atguigu.movie.bean.Movie;
import com.atguigu.movie.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieDao movieDao;

    public Movie getMovie(Integer id){
        Movie newMovie = movieDao.getNewMovie(id);
        return newMovie;
    }
}
