package com.movie.request;

import com.movie.entity.*;
import com.movie.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    private Long bookingId;

    public LocalDateTime bookingTime;

    private int ticketCount;

    private BookingStatus bookingStatus;

    private User user;

    private ShowDetails showDetails;

    private List<Ticket> ticket;

    private Payment payment;
    //only for seeat booking.
    private List<Seat> seat;

//    public BookingRequest(Long bookingId, LocalDateTime bookingTime, int ticketCount, BookingStatus bookingStatus, User user, ShowDetails showDetails, List<Ticket> ticket, Payment payment, List<Seat> seat) {
//        this.bookingId = bookingId;
//        this.bookingTime = bookingTime;
//        this.ticketCount = ticketCount;
//        this.bookingStatus = bookingStatus;
//        this.user = user;
//        this.showDetails = showDetails;
//        this.ticket = ticket;
//        this.payment = payment;
//        this.seat = seat;
//    }
//
//    public BookingRequest() {
//    }
//
//    public Long getBookingId() {
//        return this.bookingId;
//    }
//
//    public LocalDateTime getBookingTime() {
//        return this.bookingTime;
//    }
//
//    public int getTicketCount() {
//        return this.ticketCount;
//    }
//
//    public BookingStatus getBookingStatus() {
//        return this.bookingStatus;
//    }
//
//    public User getUser() {
//        return this.user;
//    }
//
//    public ShowDetails getShowDetails() {
//        return this.showDetails;
//    }
//
//    public List<Ticket> getTicket() {
//        return this.ticket;
//    }
//
//    public Payment getPayment() {
//        return this.payment;
//    }
//
//    public List<Seat> getSeat() {
//        return this.seat;
//    }
//
//    public void setBookingId(Long bookingId) {
//        this.bookingId = bookingId;
//    }
//
//    public void setBookingTime(LocalDateTime bookingTime) {
//        this.bookingTime = bookingTime;
//    }
//
//    public void setTicketCount(int ticketCount) {
//        this.ticketCount = ticketCount;
//    }
//
//    public void setBookingStatus(BookingStatus bookingStatus) {
//        this.bookingStatus = bookingStatus;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setShowDetails(ShowDetails showDetails) {
//        this.showDetails = showDetails;
//    }
//
//    public void setTicket(List<Ticket> ticket) {
//        this.ticket = ticket;
//    }
//
//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }
//
//    public void setSeat(List<Seat> seat) {
//        this.seat = seat;
//    }
//
//    public String toString() {
//        return "BookingRequest(bookingId=" + this.getBookingId() + ", bookingTime=" + this.getBookingTime() + ", ticketCount=" + this.getTicketCount() + ", bookingStatus=" + this.getBookingStatus() + ", user=" + this.getUser() + ", showDetails=" + this.getShowDetails() + ", ticket=" + this.getTicket() + ", payment=" + this.getPayment() + ", seat=" + this.getSeat() + ")";
//    }
}
