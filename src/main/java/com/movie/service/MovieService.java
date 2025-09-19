package com.movie.service;

import java.util.List;

import com.movie.request.MovieRequest;
import com.movie.response.MovieResponse;

import jakarta.validation.Valid;

public interface MovieService {

    MovieResponse createMovie(@Valid MovieRequest movieRequest);

    MovieResponse upateMovie(MovieRequest movieRequest, @Valid Long movieId);

    List<MovieResponse> getMovieByKeyword(String keyword);

    MovieResponse getMovieByMovieId(Long movieId);

    List<MovieResponse> getAllMovies();

    void deleteMovie(Long movieId);

}
