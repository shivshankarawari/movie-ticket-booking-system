package com.movie.controller;

import com.movie.response.PrintTicketResponse;
import com.movie.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private static final Logger log = LoggerFactory.getLogger(TicketController.class);


    private final TicketService ticketService;

    @Autowired
    public TicketController(final TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<PrintTicketResponse> printTicketData(@PathVariable Long bookingId) {

        PrintTicketResponse printTicketResponse = this.ticketService.printTicketData(bookingId);

        return new ResponseEntity<PrintTicketResponse>(printTicketResponse, HttpStatus.OK);

    }

}
