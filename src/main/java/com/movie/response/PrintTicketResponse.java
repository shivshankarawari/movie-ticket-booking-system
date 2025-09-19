package com.movie.response;

import com.movie.enums.MovieFormat;
import com.movie.enums.MovieLanguage;

public class PrintTicketResponse {

    private Long bookingId;
    private String movieName;
    private MovieFormat movieFormat;
    private MovieLanguage movieLanguage;
    private String TheaterAddress;

    private String showDate;

    private String showStartTime;
    private String screenName;
    private String ListOfSeats; // coma seperated all booked seats

    public PrintTicketResponse(Long bookingId, String movieName, MovieFormat movieFormat, MovieLanguage movieLanguage, String TheaterAddress, String showDate, String showStartTime, String screenName, String ListOfSeats) {
        this.bookingId = bookingId;
        this.movieName = movieName;
        this.movieFormat = movieFormat;
        this.movieLanguage = movieLanguage;
        this.TheaterAddress = TheaterAddress;
        this.showDate = showDate;
        this.showStartTime = showStartTime;
        this.screenName = screenName;
        this.ListOfSeats = ListOfSeats;
    }

    public PrintTicketResponse() {
    }

    public Long getBookingId() {
        return this.bookingId;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public MovieFormat getMovieFormat() {
        return this.movieFormat;
    }

    public MovieLanguage getMovieLanguage() {
        return this.movieLanguage;
    }

    public String getTheaterAddress() {
        return this.TheaterAddress;
    }

    public String getShowDate() {
        return this.showDate;
    }

    public String getShowStartTime() {
        return this.showStartTime;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public String getListOfSeats() {
        return this.ListOfSeats;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieFormat(MovieFormat movieFormat) {
        this.movieFormat = movieFormat;
    }

    public void setMovieLanguage(MovieLanguage movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public void setTheaterAddress(String TheaterAddress) {
        this.TheaterAddress = TheaterAddress;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public void setShowStartTime(String showStartTime) {
        this.showStartTime = showStartTime;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setListOfSeats(String ListOfSeats) {
        this.ListOfSeats = ListOfSeats;
    }

    public String toString() {
        return "PrintTicketResponse(bookingId=" + this.getBookingId() + ", movieName=" + this.getMovieName() + ", movieFormat=" + this.getMovieFormat() + ", movieLanguage=" + this.getMovieLanguage() + ", TheaterAddress=" + this.getTheaterAddress() + ", showDate=" + this.getShowDate() + ", showStartTime=" + this.getShowStartTime() + ", screenName=" + this.getScreenName() + ", ListOfSeats=" + this.getListOfSeats() + ")";
    }

    // we can show more info like movie poster and QR scanner.

}
