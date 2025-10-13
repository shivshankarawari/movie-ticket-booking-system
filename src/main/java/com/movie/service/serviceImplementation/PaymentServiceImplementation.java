package com.movie.service.serviceImplementation;

import com.movie.entity.Booking;
import com.movie.entity.Payment;
import com.movie.repository.PaymentRepository;
import com.movie.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplementation implements PaymentService {
    private static final Logger log = LoggerFactory.getLogger(PaymentServiceImplementation.class);

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImplementation(final PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayement(Booking booking, String paymentMode, Double totalAmount) {
        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setPaymentMode(paymentMode);
        payment.setTotalAmount(totalAmount);
        return this.paymentRepository.save(payment);
    }

    @Override
    public Payment refundPayment(Booking booking) {
        // TODO Auto-generated method stub
        return null;
    }

}
