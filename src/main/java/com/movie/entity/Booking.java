package com.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movie.enums.BookingStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "bookings")
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    public LocalDateTime bookingTime;

    @Column(name = "ticket_count", nullable = false)
    private int ticketCount;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private ShowDetails showDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Ticket> ticket;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

    public Booking(Long bookingId, LocalDateTime bookingTime, int ticketCount, BookingStatus bookingStatus, User user, ShowDetails showDetails, List<Ticket> ticket, Payment payment) {
        this.bookingId = bookingId;
        this.bookingTime = bookingTime;
        this.ticketCount = ticketCount;
        this.bookingStatus = bookingStatus;
        this.user = user;
        this.showDetails = showDetails;
        this.ticket = ticket;
        this.payment = payment;
    }

    public Booking() {
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

    public BookingStatus getBookingStatus() {
        return this.bookingStatus;
    }

    public User getUser() {
        return this.user;
    }

    public ShowDetails getShowDetails() {
        return this.showDetails;
    }

    public List<Ticket> getTicket() {
        return this.ticket;
    }

    public Payment getPayment() {
        return this.payment;
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

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShowDetails(ShowDetails showDetails) {
        this.showDetails = showDetails;
    }

    @JsonIgnore
    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}