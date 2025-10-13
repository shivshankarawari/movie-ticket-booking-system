package com.movie.controller;

import com.movie.exception.ApiResponse;
import com.movie.request.MovieRequest;
import com.movie.response.MovieResponse;
import com.movie.service.MovieService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;

    @Autowired
    public MovieController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping()
    public ResponseEntity<MovieResponse> createMovies(@Valid @RequestBody MovieRequest movieRequest) {
        movieRequest.setReview(Collections.emptyList());
        movieRequest.setShowDetails(Collections.emptyList());
        MovieResponse createMovie = this.movieService.createMovie(movieRequest);
        return new ResponseEntity<MovieResponse>(createMovie, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllMovies() {
        List<MovieResponse> movies = this.movieService.getAllMovies();

        return new ResponseEntity<>((!movies.isEmpty()) ? movies : new ApiResponse("Movie list is empty ", true),
                HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieResponse> getMovieByMovieId(@PathVariable Long movieId) {
        MovieResponse movieById = this.movieService.getMovieByMovieId(movieId);
        logger.info(movieById.toString());
        return new ResponseEntity<MovieResponse>(movieById, HttpStatus.OK);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieResponse> updateMovie(@Valid @PathVariable Long movieId,
                                                     @RequestBody MovieRequest movieRequest) {
        MovieResponse updatedMovie = this.movieService.upateMovie(movieRequest, movieId);
        return new ResponseEntity<MovieResponse>(updatedMovie, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> getMovieByKeyword(@PathVariable String keyword) {
        List<MovieResponse> serchedmovie = this.movieService.getMovieByKeyword(keyword);
        return new ResponseEntity<>((!serchedmovie.isEmpty()) ? serchedmovie
                : new ApiResponse("Movie not found with keyword: " + keyword, true), HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<ApiResponse> deleteMovie(@PathVariable Long movieId) {
        this.movieService.deleteMovie(movieId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Movie Deleted Successfully", true), HttpStatus.OK);
    }
}
