package com.movie.controller;

import com.movie.exception.ApiResponse;
import com.movie.request.TheaterRequest;
import com.movie.response.NearByTheaterResponse;
import com.movie.response.TheaterResponse;
import com.movie.service.TheaterService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/theaters")
public class TheaterController {
    private static final Logger log = LoggerFactory.getLogger(TheaterController.class);
    private final TheaterService theaterService;

    @Autowired
    public TheaterController(final TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @PostMapping("/create")
    public ResponseEntity<TheaterResponse> createTheater(@Valid @RequestBody TheaterRequest theaterRequest) {
        TheaterResponse theaterResponse = this.theaterService.createTheater(theaterRequest);
        return new ResponseEntity<TheaterResponse>(theaterResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllTheatres() {
        List<TheaterResponse> allTheatersList = this.theaterService.getAllTheatres();

        return new ResponseEntity<>(
                (!allTheatersList.isEmpty()) ? allTheatersList : new ApiResponse("Theater list is empty ", true),
                HttpStatus.OK);
    }

    @GetMapping("/find/{theaterId}")
    public ResponseEntity<TheaterResponse> getTheatreByTheaterId(@PathVariable Long theaterId) {
        TheaterResponse theaterById = this.theaterService.getTheaterByTheaterId(theaterId);
        System.out.println("theater value" + theaterById.toString());
        return new ResponseEntity<TheaterResponse>(theaterById, HttpStatus.OK);
    }

    @GetMapping("/search/nearby")
    public ResponseEntity<List<NearByTheaterResponse>> getNearByTheaters(
            @RequestParam(value = "latitude", required = true) Double latitude,
            @RequestParam(value = "longitude", required = true) Double longitude,
            @RequestParam(value = "radius", required = false, defaultValue = "15.00") Double radius) {
        List<NearByTheaterResponse> nearbyTheaters = this.theaterService.getNearByTheater(latitude, longitude, radius);
        return new ResponseEntity<List<NearByTheaterResponse>>(nearbyTheaters, HttpStatus.OK);

    }

    @PutMapping("/update/{theaterId}")
    public ResponseEntity<TheaterResponse> updateTheater(@Valid @PathVariable Long theaterId,
                                                         @RequestBody TheaterRequest theaterRequest) {
        TheaterResponse updatedTheater = this.theaterService.upateTheater(theaterRequest, theaterId);
        return new ResponseEntity<TheaterResponse>(updatedTheater, HttpStatus.OK);
    }

    @GetMapping("/search/keyword/{keyword}")
    public ResponseEntity<?> getTheaterByKeyword(@PathVariable String keyword) {
        List<TheaterResponse> serchedtheater = this.theaterService.getTheaterByKeyword(keyword);

        return new ResponseEntity<>((!serchedtheater.isEmpty()) ? serchedtheater
                : new ApiResponse("Theater not found with keyword: " + keyword, true), HttpStatus.OK);
    }

    @DeleteMapping("delete/{theaterId}")
    public ResponseEntity<ApiResponse> deleteTheater(@PathVariable Long theaterId) {
        this.theaterService.deleteTheater(theaterId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Theater Deleted Successfully", true), HttpStatus.OK);
    }

}
