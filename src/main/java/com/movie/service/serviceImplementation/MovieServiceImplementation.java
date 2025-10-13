package com.movie.service.serviceImplementation;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;
import com.movie.request.MovieRequest;
import com.movie.response.MovieResponse;
import com.movie.service.MovieService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImplementation implements MovieService {
    private static final Logger log = LoggerFactory.getLogger(MovieServiceImplementation.class);
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MovieServiceImplementation(final MovieRepository movieRepository, final ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MovieResponse createMovie(@Valid MovieRequest movieRequest) {
        movieRequest.setGenre(movieRequest.getGenre().trim().toUpperCase());
        Movie movie = this.modelMapper.map(movieRequest, Movie.class);
        return this.modelMapper.map(this.movieRepository.save(movie), MovieResponse.class);
    }

    @Override
    public MovieResponse getMovieByMovieId(Long movieId) {
        Movie movie = this.movieRepository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", movieId)));

        return this.modelMapper.map(movie, MovieResponse.class);
    }

    @Override
    public MovieResponse upateMovie(MovieRequest movieRequest, @Valid Long movieId) {
        MovieResponse movieResponse = this.getMovieByMovieId(movieId);
        movieResponse.setMovieName(movieRequest.getMovieName());
        movieResponse.setReleaseDate(movieRequest.getReleaseDate());
        movieResponse.setDescription(movieRequest.getDescription());
        movieResponse.setDuration(movieRequest.getDuration());
        movieResponse.setGenre(movieRequest.getGenre());
        Movie updatedMovie = this.movieRepository.save(this.modelMapper.map(movieResponse, Movie.class));
        return this.modelMapper.map(updatedMovie, MovieResponse.class);
    }

    @Override
    public List<MovieResponse> getMovieByKeyword(String keyword) {
        return this.movieRepository.findByKeyword(keyword).stream().map(source -> this.modelMapper.map(source, MovieResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        return this.movieRepository.findAll().stream().map(e -> this.modelMapper.map(e, MovieResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteMovie(Long movieId) {
        this.movieRepository.delete(this.modelMapper.map(this.getMovieByMovieId(movieId), Movie.class));
    }

}
