package com.movie.service;

import java.util.List;

import com.movie.entity.Seat;
import com.movie.request.BookingRequest;
import com.movie.response.PrintTicketResponse;

public interface TicketService {

    PrintTicketResponse printTicketData(Long bookingId);

    List<Seat> createTicket(BookingRequest bookingRequest);

}
