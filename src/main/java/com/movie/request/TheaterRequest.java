package com.movie.request;

import com.movie.response.ScreenResponse;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

/**
 * Request class for Theater.
 */
public class TheaterRequest {

    private Long theaterId;
    @NotBlank(message = "Theater name should not be blank")
    private String theaterName;
    private int screenCount;

    private String street;
    private String city;
    private String state;
    private String zip;

    private double longitude; // vertical lines
    private double latitude; // horizontal lines
    private Set<ScreenResponse> screen;

    public TheaterRequest(Long theaterId, @NotBlank(message = "Theater name should not be blank") String theaterName, int screenCount, String street, String city, String state, String zip, double longitude, double latitude, Set<ScreenResponse> screen) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.screenCount = screenCount;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.longitude = longitude;
        this.latitude = latitude;
        this.screen = screen;
    }

    public TheaterRequest() {
    }

    public Long getTheaterId() {
        return this.theaterId;
    }

    public @NotBlank(message = "Theater name should not be blank") String getTheaterName() {
        return this.theaterName;
    }

    public int getScreenCount() {
        return this.screenCount;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZip() {
        return this.zip;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public Set<ScreenResponse> getScreen() {
        return this.screen;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    public void setTheaterName(@NotBlank(message = "Theater name should not be blank") String theaterName) {
        this.theaterName = theaterName;
    }

    public void setScreenCount(int screenCount) {
        this.screenCount = screenCount;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setScreen(Set<ScreenResponse> screen) {
        this.screen = screen;
    }

    public String toString() {
        return "TheaterRequest(theaterId=" + this.getTheaterId() + ", theaterName=" + this.getTheaterName() + ", screenCount=" + this.getScreenCount() + ", street=" + this.getStreet() + ", city=" + this.getCity() + ", state=" + this.getState() + ", zip=" + this.getZip() + ", longitude=" + this.getLongitude() + ", latitude=" + this.getLatitude() + ", screen=" + this.getScreen() + ")";
    }
}
