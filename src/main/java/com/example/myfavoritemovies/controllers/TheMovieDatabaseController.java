package com.example.myfavoritemovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myfavoritemovies.services.TheMovieDatabaseService;

@RestController
@RequestMapping("/movies")
public class TheMovieDatabaseController {
    @Autowired
    TheMovieDatabaseService themoviedb;
    
    @Value("${jwt.secret}")
    String SECRET_KEY;

    String auth = "Bearer ";

    @GetMapping("trending-day")
    public ResponseEntity<String> MovieTrendsDay(){
        return ResponseEntity.ok().body(themoviedb.trendingDayMovies(auth + SECRET_KEY));
    }

    @GetMapping("trending-week")
    public ResponseEntity<String> movieTrendsWeek(){
        return ResponseEntity.ok().body(themoviedb.trendingWeekMovies(auth + SECRET_KEY));
    }
    
    @GetMapping("top-rated")
    public ResponseEntity<String> topRatedMovie(){
        return ResponseEntity.ok().body(themoviedb.topRatedMovies(auth + SECRET_KEY));
    }

    @GetMapping("popular")
    public ResponseEntity<String> popularMovie(){
        return ResponseEntity.ok().body(themoviedb.popularMovies(auth + SECRET_KEY));
    }

    @GetMapping("now-playing")
    public ResponseEntity<String> nowPlayingMovie(){
        return ResponseEntity.ok().body(themoviedb.nowPlayingMovies(auth + SECRET_KEY));
    }

    @GetMapping("upcoming")
    public ResponseEntity<String> upcomingMovie(){
        return ResponseEntity.ok().body(themoviedb.upcomingMovies(auth + SECRET_KEY));
    }
}
