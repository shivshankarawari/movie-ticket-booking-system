package com.movie.response;

import com.movie.entity.Booking;
import com.movie.entity.Movie;
import com.movie.entity.Screen;
import com.movie.enums.MovieFormat;
import com.movie.enums.MovieLanguage;

import java.time.LocalDateTime;
import java.util.List;

public class ShowDetailsResponse {
    private int showId;
    private Long totalSeats;
    private Long bookedSeats;
    private Long availableSeats;

    public LocalDateTime showTime;


    private int baseTicketRate;

    private Movie movie;

    private Screen screen;

    private MovieFormat movieFormat;

    private MovieLanguage movieLanguage;

    private List<Booking> boooking;

    public ShowDetailsResponse(int showId, Long totalSeats, Long bookedSeats, Long availableSeats, LocalDateTime showTime, int baseTicketRate, Movie movie, Screen screen, MovieFormat movieFormat, MovieLanguage movieLanguage, List<Booking> boooking) {
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

    public ShowDetailsResponse() {
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

    public void setBoooking(List<Booking> boooking) {
        this.boooking = boooking;
    }
}
