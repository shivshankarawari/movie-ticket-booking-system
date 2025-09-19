package com.movie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    private String paymentMode; // UPI//CREDITCARD
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Payment(Long paymentId, Double totalAmount, String paymentMode, Booking booking) {
        this.paymentId = paymentId;
        this.totalAmount = totalAmount;
        this.paymentMode = paymentMode;
        this.booking = booking;
    }

    public Payment() {
    }

    public Long getPaymentId() {
        return this.paymentId;
    }

    public Double getTotalAmount() {
        return this.totalAmount;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
