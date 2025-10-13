package com.movie.controller;

import com.movie.request.SeatRequest;
import com.movie.response.SeatResponse;
import com.movie.service.SeatService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seats")
public class SeatController {
    private static final Logger logger = LoggerFactory.getLogger(SeatController.class);

    private final SeatService seatService;

    @Autowired
    public SeatController(final SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping("/theater/{theaterId}/screen/{screenId}")
    public ResponseEntity<List<SeatResponse>> addSeatsInScreen(@Valid @RequestBody List<SeatRequest> seatRequest, @PathVariable Long theaterId, @PathVariable Long screenId) {
        logger.info("Request body(in toString): {}", seatRequest);
        List<SeatResponse> savedSeats = this.seatService.addSeatsInScreen(seatRequest, theaterId, screenId);
        logger.info("Sending response with status {}: {}", 200, savedSeats);
        return new ResponseEntity<List<SeatResponse>>(savedSeats, HttpStatus.CREATED);
    }

    // Seach seats in particular theater or screen
    @GetMapping("/search/theater/{theaterId}/screen/{screenId}/seats/")
    public ResponseEntity<List<SeatResponse>> getAllSeatsInSpecificScreen(@PathVariable Long theaterId, @PathVariable Long screenId) {
        List<SeatResponse> screenList = this.seatService.getAllSeatsInSpecificScreen(theaterId, screenId);
        return new ResponseEntity<List<SeatResponse>>(screenList, HttpStatus.OK);
    }

}
