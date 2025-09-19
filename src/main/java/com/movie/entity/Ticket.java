package com.movie.entity;

import jakarta.persistence.*;

@Entity

@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String seatNumber;
    private double price;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Ticket(Long ticketId, String seatNumber, double price, Booking booking) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
        this.price = price;
        this.booking = booking;
    }

    public Ticket() {
    }

    public Long getTicketId() {
        return this.ticketId;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public double getPrice() {
        return this.price;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    // create orientation for screen with name like a2, f4:

}
