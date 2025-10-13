package com.movie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.movie.exception.ApiResponse;
import com.movie.request.ShowDetailsRequest;
import com.movie.response.ShowDetailsResponse;
import com.movie.service.ShowDetailsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowDetailsController {
    private static final Logger log = LoggerFactory.getLogger(ShowDetailsController.class);

    private final ShowDetailsService showDetailsService;

    @Autowired
    public ShowDetailsController(final ShowDetailsService showDetailsService) {
        this.showDetailsService = showDetailsService;
    }


    // Implementation to avoid show duplication
    @PostMapping("/movies/{movieId}/theater/{theaterId}/screen/{screenId}")
    public ResponseEntity<ShowDetailsResponse> createShowDetails(@Valid @RequestBody ShowDetailsRequest showDetailsRequest, @PathVariable Long movieId, @PathVariable Long theaterId, @PathVariable Long screenId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        log.info("Request body(in toString): {}", showDetailsRequest);
        log.info("Request body(in json): {}", objectMapper.writeValueAsString(showDetailsRequest));
        ShowDetailsResponse savedShow = this.showDetailsService.createShowDetails(showDetailsRequest, movieId, theaterId, screenId);
        log.info("Sending response with status {}: {}", 200, savedShow);
        log.info("Sending response with status {}: {}", 200, objectMapper.writeValueAsString(savedShow));
        return new ResponseEntity<>(savedShow, HttpStatus.CREATED);
    }

    @GetMapping("/{showDetailsId}")
    public ResponseEntity<ShowDetailsResponse> getShowDetailsByShowDetailsId(@PathVariable Long showDetailsId) {
        ShowDetailsResponse showDetailsById = this.showDetailsService.getShowDetailsByShowDetailsId(showDetailsId);
        return new ResponseEntity<ShowDetailsResponse>(showDetailsById, HttpStatus.OK);
    }

    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<?> getAllShowDetailsByTheaterId(@PathVariable Long theaterId) {
        List<ShowDetailsResponse> showDetails = this.showDetailsService.getAllShowDetailsByTheaterId(theaterId);
        return new ResponseEntity<>((!showDetails.isEmpty()) ? showDetails : new ApiResponse("ShowDetails list is empty ", true), HttpStatus.OK);
    }

    @DeleteMapping("/showDetails/{showDetailsId}")
    public ResponseEntity<ApiResponse> deleteShowDetails(@PathVariable Long showDetailsId) {
        this.showDetailsService.deleteShowDetails(showDetailsId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("ShowDetails Deleted Successfully", true), HttpStatus.OK);
    }

//	@PutMapping("/update/{showDetailsId}")
//	public ResponseEntity<ShowDetailsResponse> updateShowDetails(@Valid @PathVariable Long showDetailsId,
//			@RequestBody ShowDetailsResponse showDetailsRequest) {
//		ShowDetailsResponse updatedShowDetails = this.showDetailsService.upateShowDetails(showDetailsRequest,
//				showDetailsId);
//		return new ResponseEntity<ShowDetailsResponse>(updatedShowDetails, HttpStatus.OK);
//	}

    @GetMapping("/search/showDetails/{movieId}")
    public ResponseEntity<?> getShowDetailsByMovieId(@PathVariable Long movieId) {
        System.out.println("inside search");
        List<ShowDetailsResponse> serchedshow = this.showDetailsService.getShowDetailsByMovieId(movieId);
        return new ResponseEntity<>((!serchedshow.isEmpty()) ? serchedshow : new ApiResponse("Show not found with movieId: " + movieId, true), HttpStatus.OK);
    }

}
