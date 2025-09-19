package com.movie.response;

import com.movie.entity.Booking;
import com.movie.entity.Movie;
import com.movie.entity.Screen;
import com.movie.enums.MovieFormat;
import com.movie.enums.MovieLanguage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ShowResponse {

    private int showId;
    private int totalSeats;
    private int bookedSeats;
    private int availableSeats;

    private LocalDate showDate;

    private LocalTime showStartTime;

    private int bsaseTicketRate;

    private Movie movie;

    private Screen screen;

    private MovieFormat movieFormat;

    private MovieLanguage movieLanguage;

    private List<Booking> boooking;

    public ShowResponse(int showId, int totalSeats, int bookedSeats, int availableSeats, LocalDate showDate, LocalTime showStartTime, int bsaseTicketRate, Movie movie, Screen screen, MovieFormat movieFormat, MovieLanguage movieLanguage, List<Booking> boooking) {
        this.showId = showId;
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
        this.availableSeats = availableSeats;
        this.showDate = showDate;
        this.showStartTime = showStartTime;
        this.bsaseTicketRate = bsaseTicketRate;
        this.movie = movie;
        this.screen = screen;
        this.movieFormat = movieFormat;
        this.movieLanguage = movieLanguage;
        this.boooking = boooking;
    }

    public ShowResponse() {
    }

    public int getShowId() {
        return this.showId;
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public int getBookedSeats() {
        return this.bookedSeats;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public LocalDate getShowDate() {
        return this.showDate;
    }

    public LocalTime getShowStartTime() {
        return this.showStartTime;
    }

    public int getBsaseTicketRate() {
        return this.bsaseTicketRate;
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

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public void setShowStartTime(LocalTime showStartTime) {
        this.showStartTime = showStartTime;
    }

    public void setBsaseTicketRate(int bsaseTicketRate) {
        this.bsaseTicketRate = bsaseTicketRate;
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

    public String toString() {
        return "ShowResponse(showId=" + this.getShowId() + ", totalSeats=" + this.getTotalSeats() + ", bookedSeats=" + this.getBookedSeats() + ", availableSeats=" + this.getAvailableSeats() + ", showDate=" + this.getShowDate() + ", showStartTime=" + this.getShowStartTime() + ", bsaseTicketRate=" + this.getBsaseTicketRate() + ", movie=" + this.getMovie() + ", screen=" + this.getScreen() + ", movieFormat=" + this.getMovieFormat() + ", movieLanguage=" + this.getMovieLanguage() + ", boooking=" + this.getBoooking() + ")";
    }
}
