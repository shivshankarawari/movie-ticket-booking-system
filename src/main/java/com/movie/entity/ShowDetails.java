package com.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movie.enums.MovieFormat;
import com.movie.enums.MovieLanguage;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "show_details")
public class ShowDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;
    private Long totalSeats;
    private Long bookedSeats;
    private Long availableSeats;

    @Column(name = "show_time", nullable = false)
    public LocalDateTime showTime;

    @Column(name = "base_ticket_rate", nullable = false)
    private int baseTicketRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @Column(name = "movie_format", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieFormat movieFormat;

    @Column(name = "movie_language", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieLanguage movieLanguage;

    @JsonIgnore
    @OneToMany(mappedBy = "showDetails")
    private List<Booking> boooking;

    public ShowDetails(int showId, Long totalSeats, Long bookedSeats, Long availableSeats, LocalDateTime showTime, int baseTicketRate, Movie movie, Screen screen, MovieFormat movieFormat, MovieLanguage movieLanguage, List<Booking> boooking) {
        this.showId = showId;
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
        this.availableSeats = availableSeats;
        this.showTime = showTime;
        this.baseTicketRate = baseTicketRate;
        this.movie = movie;
        this.screen = screen;
        this.movieFormat = movieFormat;
        this.movieLanguage = movieLanguage;
        this.boooking = boooking;
    }

    public ShowDetails() {
    }

    public int getShowId() {
        return this.showId;
    }

    public Long getTotalSeats() {
        return this.totalSeats;
    }

    public Long getBookedSeats() {
        return this.bookedSeats;
    }

    public Long getAvailableSeats() {
        return this.availableSeats;
    }

    public LocalDateTime getShowTime() {
        return this.showTime;
    }

    public int getBaseTicketRate() {
        return this.baseTicketRate;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public MovieFormat getMovieFormat() {
        return this.movieFormat;
    }

    public MovieLanguage getMovieLanguage() {
        return this.movieLanguage;
    }

    public List<Booking> getBoooking() {
        return this.boooking;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public void setTotalSeats(Long totalSeats) {
        this.totalSeats = totalSeats;
    }

    public void setBookedSeats(Long bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public void setAvailableSeats(Long availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public void setBaseTicketRate(int baseTicketRate) {
        this.baseTicketRate = baseTicketRate;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setMovieFormat(MovieFormat movieFormat) {
        this.movieFormat = movieFormat;
    }

    public void setMovieLanguage(MovieLanguage movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    @JsonIgnore
    public void setBoooking(List<Booking> boooking) {
        this.boooking = boooking;
    }
}
