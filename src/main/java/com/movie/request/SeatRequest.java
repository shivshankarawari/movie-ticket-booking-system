package com.movie.request;

import com.movie.entity.Screen;
import com.movie.enums.SeatStatus;
import com.movie.enums.SeatType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest {

    private Long seatId;
    @Positive // 0 is invalid..
    @NotNull
    private String seatNumber;
    @NotBlank
    private String rowName;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Positive
    @NotNull
    private int seatPrice;

    private Screen screen;

    public SeatRequest(Long seatId, @Positive @NotNull String seatNumber, @NotBlank String rowName, SeatStatus status, SeatType seatType, @Positive @NotNull int seatPrice, Screen screen) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.rowName = rowName;
        this.status = status;
        this.seatType = seatType;
        this.seatPrice = seatPrice;
        this.screen = screen;
    }

    public SeatRequest() {
    }

    public Long getSeatId() {
        return this.seatId;
    }

    public @Positive @NotNull String getSeatNumber() {
        return this.seatNumber;
    }

    public @NotBlank String getRowName() {
        return this.rowName;
    }

    public SeatStatus getStatus() {
        return this.status;
    }

    public SeatType getSeatType() {
        return this.seatType;
    }

    public @Positive @NotNull int getSeatPrice() {
        return this.seatPrice;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public void setSeatNumber(@Positive @NotNull String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setRowName(@NotBlank String rowName) {
        this.rowName = rowName;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public void setSeatPrice(@Positive @NotNull int seatPrice) {
        this.seatPrice = seatPrice;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public String toString() {
        return "SeatRequest(seatId=" + this.getSeatId() + ", seatNumber=" + this.getSeatNumber() + ", rowName=" + this.getRowName() + ", status=" + this.getStatus() + ", seatType=" + this.getSeatType() + ", seatPrice=" + this.getSeatPrice() + ", screen=" + this.getScreen() + ")";
    }
}
