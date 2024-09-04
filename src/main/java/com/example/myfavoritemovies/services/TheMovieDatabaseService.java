package com.example.myfavoritemovies.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url="https://api.themoviedb.org/", name="The-Movie-Database")
public interface TheMovieDatabaseService {
 
    @GetMapping("3/movie/now_playing?language=pt-BR&page=1")
    String nowPlayingMovies(@RequestHeader("Authorization") String AcessToken);

    @GetMapping("3/movie/popular?language=pt-BR&page=1")
    String popularMovies(@RequestHeader("Authorization") String AcessToken);

    @GetMapping("3/movie/top_rated?language=pt-BR&page=1")
    String topRatedMovies(@RequestHeader("Authorization") String AcessToken);

    @GetMapping("3/movie/upcoming?language=pt-BR&page=1")
    String upcomingMovies(@RequestHeader("Authorization") String AcessToken);

    @GetMapping("3/trending/movie/day?language=pt-BR")
    String trendingDayMovies(@RequestHeader("Authorization") String AcessToken);

    @GetMapping("3/trending/movie/week?language=pt-BR")
    String trendingWeekMovies(@RequestHeader("Authorization") String AcessToken);
}
