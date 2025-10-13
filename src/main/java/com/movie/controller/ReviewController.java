package com.movie.controller;

import com.movie.exception.ApiResponse;
import com.movie.request.ReviewRequest;
import com.movie.response.ReviewResponse;
import com.movie.service.ReviewService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(final ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/user/{userId}/movie/{movieId}")
    public ResponseEntity<ReviewResponse> doRatingForMovie(@Valid @RequestBody ReviewRequest reviewRequest,
                                                           @PathVariable String userId, @PathVariable Long movieId) {
        ReviewResponse createReview = this.reviewService.createReview(reviewRequest, userId, movieId);
        return new ResponseEntity<>(createReview, HttpStatus.CREATED);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResponse> getReviewByReviewId(@PathVariable Long reviewId) {
        ReviewResponse reviewById = this.reviewService.getReviewByReviewId(reviewId);
        return new ResponseEntity<>(reviewById, HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByMoviewId(@PathVariable Long movieId) {
        List<ReviewResponse> movieReviews = this.reviewService.getReviewsByMovieId(movieId);
        return new ResponseEntity<>(movieReviews, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllReviews() {
        List<ReviewResponse> reviews = this.reviewService.getAllReviews();
        return new ResponseEntity<>((!reviews.isEmpty()) ? reviews : new ApiResponse("Review list is empty ", true),
                HttpStatus.OK);
    }

}
