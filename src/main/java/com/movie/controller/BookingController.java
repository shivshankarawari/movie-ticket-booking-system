package com.movie.controller;

import com.movie.entity.Booking;
import com.movie.exception.ApiResponse;
import com.movie.request.BookingRequest;
import com.movie.response.BookingResponse;
import com.movie.service.BookingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//test chang
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    private final BookingService bookingService;

    @Autowired
    public BookingController(final BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/showdetail/{showId}/users/{userId}")
    public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody BookingRequest bookingRequest, @PathVariable Long showId, @PathVariable String userId) {
        logger.info("request in booking contrl");
        BookingResponse createBooking = this.bookingService.createBooking(bookingRequest, showId, userId);
        return new ResponseEntity<>(createBooking, HttpStatus.CREATED);
    }

    @PutMapping("/update/{bookingId}")
    public ResponseEntity<BookingResponse> updateBooking(@Valid @PathVariable Long bookingId, @RequestBody BookingRequest bookingRequest) {
        BookingResponse updatedBooking = this.bookingService.updateBooking(bookingRequest, bookingId);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    @GetMapping("/search/{userName}")
    public ResponseEntity<List<BookingResponse>> getAllBookingsForUser(@PathVariable String emailId) {
        List<BookingResponse> serchedbooking = this.bookingService.getAllBookingsForUser(emailId);
        return new ResponseEntity<>(serchedbooking, HttpStatus.OK);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingByBookingId(@PathVariable Long bookingId) {
        Booking bookingById = this.bookingService.getBookingByBookingId(bookingId);
        return new ResponseEntity<>(bookingById, HttpStatus.OK);

    }

    @DeleteMapping("/cancelation/{bookingId}")
    public ResponseEntity<ApiResponse> deleteBooking(@PathVariable Long bookingId) {
        this.bookingService.cancelBooking(bookingId);
        return new ResponseEntity<>(new ApiResponse("Booking cancelation Successful.", true), HttpStatus.OK);
    }

}
