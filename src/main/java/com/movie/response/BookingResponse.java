package com.movie.response;

import com.movie.entity.Seat;
import com.movie.entity.ShowDetails;
import com.movie.entity.User;
import com.movie.enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;

public class BookingResponse {

    private Long bookingId;

    public LocalDateTime bookingTime;

    private int ticketCount;

    private int totalAmount;

    private BookingStatus bookingStatus;

    private User user;

    private ShowDetails showDetails;

    //only for seat booking.
    private List<Seat> seat;

    public BookingResponse(Long bookingId, LocalDateTime bookingTime, int ticketCount, int totalAmount, BookingStatus bookingStatus, User user, ShowDetails showDetails, List<Seat> seat) {
        this.bookingId = bookingId;
        this.bookingTime = bookingTime;
        this.ticketCount = ticketCount;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
        this.user = user;
        this.showDetails = showDetails;
        this.seat = seat;
    }

    public BookingResponse() {
    }

    public Long getBookingId() {
        return this.bookingId;
    }

    public LocalDateTime getBookingTime() {
        return this.bookingTime;
    }

    public int getTicketCount() {
        return this.ticketCount;
    }

    public int getTotalAmount() {
        return this.totalAmount;
    }

    public BookingStatus getBookingStatus() {
        return this.bookingStatus;
    }

    public User getUser() {
        return this.user;
    }

    public ShowDetails getShowDetails() {
        return this.showDetails;
    }

    public List<Seat> getSeat() {
        return this.seat;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShowDetails(ShowDetails showDetails) {
        this.showDetails = showDetails;
    }

    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }

    public String toString() {
        return "BookingResponse(bookingId=" + this.getBookingId() + ", bookingTime=" + this.getBookingTime() + ", ticketCount=" + this.getTicketCount() + ", totalAmount=" + this.getTotalAmount() + ", bookingStatus=" + this.getBookingStatus() + ", user=" + this.getUser() + ", showDetails=" + this.getShowDetails() + ", seat=" + this.getSeat() + ")";
    }
}
