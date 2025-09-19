package com.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movie.enums.SeatStatus;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "screens")
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long screenId;

    private String screenName;

    @Column(name = "seats_capacity", nullable = false)
    private Long seatsCapacity;

    @JsonIgnore
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<ShowDetails> show;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @JsonIgnore
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Seat> seat;

    public Screen() {
    }

    // to reset the seat status
    @Transient
    public void resetSeats() {
        for (Seat s : seat) {
            s.setStatus(SeatStatus.AVAILABLE);
        }
    }

    public long getScreenId() {
        return this.screenId;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public Long getSeatsCapacity() {
        return this.seatsCapacity;
    }

    public List<ShowDetails> getShow() {
        return this.show;
    }

    public Theater getTheater() {
        return this.theater;
    }

    public List<Seat> getSeat() {
        return this.seat;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setSeatsCapacity(Long seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }

    @JsonIgnore
    public void setShow(List<ShowDetails> show) {
        this.show = show;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @JsonIgnore
    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }
}
