package com.movie.service;

import com.movie.entity.Booking;
import com.movie.request.BookingRequest;
import com.movie.response.BookingResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface BookingService {

    BookingResponse createBooking(BookingRequest bookingRequest, Long showId, String userId);

    BookingResponse updateBooking(BookingRequest bookingRequest, @Valid Long bookingId);

    List<BookingResponse> getAllBookingsForUser(String emailId);

    Booking getBookingByBookingId(Long bookingId);

    void cancelBooking(Long bookingId);
}
