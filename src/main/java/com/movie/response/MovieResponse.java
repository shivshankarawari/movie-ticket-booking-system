package com.movie.response;

import com.movie.entity.Review;
import com.movie.entity.ShowDetails;

import java.time.LocalDateTime;
import java.util.List;


public class MovieResponse {

    private Long movieId;

    private String movieName;

    public LocalDateTime releaseDate;

    private Integer duration;

    private String description;

    private String genre;

    private List<ShowDetails> showDetails;
    private List<Review> review;

    public MovieResponse(Long movieId, String movieName, LocalDateTime releaseDate, Integer duration, String description, String genre, List<ShowDetails> showDetails, List<Review> review) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.description = description;
        this.genre = genre;
        this.showDetails = showDetails;
        this.review = review;
    }

    public MovieResponse() {
    }

    public Long getMovieId() {
        return this.movieId;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public LocalDateTime getReleaseDate() {
        return this.releaseDate;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGenre() {
        return this.genre;
    }

    public List<ShowDetails> getShowDetails() {
        return this.showDetails;
    }

    public List<Review> getReview() {
        return this.review;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setShowDetails(List<ShowDetails> showDetails) {
        this.showDetails = showDetails;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public String toString() {
        return "MovieResponse(movieId=" + this.getMovieId() + ", movieName=" + this.getMovieName() + ", releaseDate=" + this.getReleaseDate() + ", duration=" + this.getDuration() + ", description=" + this.getDescription() + ", genre=" + this.getGenre() + ", showDetails=" + this.getShowDetails() + ", review=" + this.getReview() + ")";
    }
}
