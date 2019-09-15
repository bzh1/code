package com.atguigu.user.feign.fallback;

import com.atguigu.user.bean.Movie;
import com.atguigu.user.feign.MovieFeignService;
import org.springframework.stereotype.Service;

@Service
public class MovieFeignServiceFallBack implements MovieFeignService {
    @Override
    public Movie getMovie(Integer id) {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setMovieName("厉害了，我的国");
        return movie;
    }
}
