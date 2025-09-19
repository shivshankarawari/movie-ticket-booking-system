package com.movie.service;

import com.movie.entity.Booking;
import com.movie.entity.Payment;

public interface PaymentService {

    Payment createPayement(Booking booking, String paymentMode, Double TotalAmount );

    Payment refundPayment(Booking booking);
}
