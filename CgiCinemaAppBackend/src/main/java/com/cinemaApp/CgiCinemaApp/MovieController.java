package com.cinemaApp.CgiCinemaApp;

import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/movies")
    public Iterable<Movie> findAllMovies() {
        return this.movieRepository.findAll();
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie){
        return this.movieRepository.save(movie);
    }
}
