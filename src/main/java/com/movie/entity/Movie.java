package com.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movie.enums.MovieGenre;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="movies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieId;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    @JsonIgnore
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ShowDetails> showDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Review> review;

    public Movie(Long movieId, String movieName, LocalDateTime releaseDate, Integer duration, String description, MovieGenre genre, List<ShowDetails> showDetails, List<Review> review) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.description = description;
        this.genre = genre;
        this.showDetails = showDetails;
        this.review = review;
    }

    public Movie() {

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

    public MovieGenre getGenre() {
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

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    @JsonIgnore
    public void setMovieDetails(List<ShowDetails> showDetails) {
        this.showDetails = showDetails;
    }

    @JsonIgnore
    public void SetReview(List<Review> review) {
        this.review = review;
    }
}
