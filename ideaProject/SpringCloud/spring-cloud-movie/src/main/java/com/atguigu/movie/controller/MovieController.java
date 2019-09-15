package com.atguigu.movie.controller;

import com.atguigu.movie.bean.Movie;
import com.atguigu.movie.server.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
    @GetMapping("/movie/get/{id}")
    public Movie getMovie(@PathVariable("id") Integer id){
        System.out.println("调用了9000的功能");
       return  movieService.getMovie(id);
    }
}
