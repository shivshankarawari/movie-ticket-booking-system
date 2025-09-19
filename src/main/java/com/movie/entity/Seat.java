package com.movie.entity;

import com.movie.enums.SeatStatus;
import com.movie.enums.SeatType;
import jakarta.persistence.*;

@Table(name = "seats")
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "row_name")
    private String rowName;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Column(name = "seat_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Column(name = "seat_price", nullable = false)
    private int seatPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "screen_id")
    private Screen screen;

    public Seat() {
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
}
