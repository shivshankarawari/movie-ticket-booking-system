package com.movie.request;

import com.movie.entity.Seat;
import com.movie.entity.ShowDetails;
import com.movie.entity.Theater;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreenRequest {

    private long screenId;

    private String screenName;

    private Long seatsCapacity;

    private List<ShowDetails> show;

    private Theater theater;

    private List<Seat> seat;

//    public ScreenRequest(long screenId, String screenName, Long seatsCapacity, List<ShowDetails> show, Theater theater, List<Seat> seat) {
//        this.screenId = screenId;
//        this.screenName = screenName;
//        this.seatsCapacity = seatsCapacity;
//        this.show = show;
//        this.theater = theater;
//        this.seat = seat;
//    }
//
//    public ScreenRequest() {
//    }
//
//    public long getScreenId() {
//        return this.screenId;
//    }
//
//    public String getScreenName() {
//        return this.screenName;
//    }
//
//    public Long getSeatsCapacity() {
//        return this.seatsCapacity;
//    }
//
//    public List<ShowDetails> getShow() {
//        return this.show;
//    }
//
//    public Theater getTheater() {
//        return this.theater;
//    }
//
//    public List<Seat> getSeat() {
//        return this.seat;
//    }
//
//    public void setScreenId(long screenId) {
//        this.screenId = screenId;
//    }
//
//    public void setScreenName(String screenName) {
//        this.screenName = screenName;
//    }
//
//    public void setSeatsCapacity(Long seatsCapacity) {
//        this.seatsCapacity = seatsCapacity;
//    }
//
//    public void setShow(List<ShowDetails> show) {
//        this.show = show;
//    }
//
//    public void setTheater(Theater theater) {
//        this.theater = theater;
//    }
//
//    public void setSeat(List<Seat> seat) {
//        this.seat = seat;
//    }
//
//    public String toString() {
//        return "ScreenRequest(screenId=" + this.getScreenId() + ", screenName=" + this.getScreenName() + ", seatsCapacity=" + this.getSeatsCapacity() + ", show=" + this.getShow() + ", theater=" + this.getTheater() + ", seat=" + this.getSeat() + ")";
//    }
}
