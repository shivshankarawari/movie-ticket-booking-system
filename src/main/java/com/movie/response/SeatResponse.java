package com.movie.response;

import com.movie.entity.Screen;
import com.movie.enums.SeatStatus;
import com.movie.enums.SeatType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class SeatResponse {

    private Long seatId;

    private String seatNumber;

    private String rowName;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private int seatPrice;

    private Screen screen;

    public SeatResponse(Long seatId, String seatNumber, String rowName, SeatStatus status, SeatType seatType, int seatPrice, Screen screen) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.rowName = rowName;
        this.status = status;
        this.seatType = seatType;
        this.seatPrice = seatPrice;
        this.screen = screen;
    }

    public SeatResponse() {
    }

    public Long getSeatId() {
        return this.seatId;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public String getRowName() {
        return this.rowName;
    }

    public SeatStatus getStatus() {
        return this.status;
    }

    public SeatType getSeatType() {
        return this.seatType;
    }

    public int getSeatPrice() {
        return this.seatPrice;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public void setSeatPrice(int seatPrice) {
        this.seatPrice = seatPrice;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public String toString() {
        return "SeatResponse(seatId=" + this.getSeatId() + ", seatNumber=" + this.getSeatNumber() + ", rowName=" + this.getRowName() + ", status=" + this.getStatus() + ", seatType=" + this.getSeatType() + ", seatPrice=" + this.getSeatPrice() + ", screen=" + this.getScreen() + ")";
    }
}
