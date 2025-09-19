package com.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;

    @Column(name = "theater_name", nullable = false)
    private String theaterName;

    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state", nullable = false)
    private String state;
    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "latitude", nullable = false)
    private double latitude;
    @Column(name = "longitude", nullable = false) // horizontal lines
    private double longitude;

    @Column(name = "screen_count", nullable = false)
    private int screenCount;

    @JsonIgnore
    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private Set<Screen> screen;

    public Theater(Long theaterId, String theaterName, String street, String city, String state, String zip, double latitude, double longitude, int screenCount, Set<Screen> screen) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
        this.screenCount = screenCount;
        this.screen = screen;
    }

    public Theater() {
    }

    public Long getTheaterId() {
        return this.theaterId;
    }

    public String getTheaterName() {
        return this.theaterName;
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

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getScreenCount() {
        return this.screenCount;
    }

    public Set<Screen> getScreen() {
        return this.screen;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setScreenCount(int screenCount) {
        this.screenCount = screenCount;
    }

    @JsonIgnore
    public void setScreen(Set<Screen> screen) {
        this.screen = screen;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Theater)) return false;
        final Theater other = (Theater) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$theaterId = this.getTheaterId();
        final Object other$theaterId = other.getTheaterId();
        if (this$theaterId == null ? other$theaterId != null : !this$theaterId.equals(other$theaterId)) return false;
        final Object this$theaterName = this.getTheaterName();
        final Object other$theaterName = other.getTheaterName();
        if (this$theaterName == null ? other$theaterName != null : !this$theaterName.equals(other$theaterName))
            return false;
        final Object this$street = this.getStreet();
        final Object other$street = other.getStreet();
        if (this$street == null ? other$street != null : !this$street.equals(other$street)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) return false;
        final Object this$zip = this.getZip();
        final Object other$zip = other.getZip();
        if (this$zip == null ? other$zip != null : !this$zip.equals(other$zip)) return false;
        if (Double.compare(this.getLatitude(), other.getLatitude()) != 0) return false;
        if (Double.compare(this.getLongitude(), other.getLongitude()) != 0) return false;
        if (this.getScreenCount() != other.getScreenCount()) return false;
        final Object this$screen = this.getScreen();
        final Object other$screen = other.getScreen();
        if (this$screen == null ? other$screen != null : !this$screen.equals(other$screen)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Theater;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $theaterId = this.getTheaterId();
        result = result * PRIME + ($theaterId == null ? 43 : $theaterId.hashCode());
        final Object $theaterName = this.getTheaterName();
        result = result * PRIME + ($theaterName == null ? 43 : $theaterName.hashCode());
        final Object $street = this.getStreet();
        result = result * PRIME + ($street == null ? 43 : $street.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $state = this.getState();
        result = result * PRIME + ($state == null ? 43 : $state.hashCode());
        final Object $zip = this.getZip();
        result = result * PRIME + ($zip == null ? 43 : $zip.hashCode());
        final long $latitude = Double.doubleToLongBits(this.getLatitude());
        result = result * PRIME + (int) ($latitude >>> 32 ^ $latitude);
        final long $longitude = Double.doubleToLongBits(this.getLongitude());
        result = result * PRIME + (int) ($longitude >>> 32 ^ $longitude);
        result = result * PRIME + this.getScreenCount();
        final Object $screen = this.getScreen();
        result = result * PRIME + ($screen == null ? 43 : $screen.hashCode());
        return result;
    }
}
