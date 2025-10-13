package com.movie.service.serviceImplementation;

import com.movie.configurations.ErrorMessages;
import com.movie.configurations.SystemConstants;
import com.movie.entity.Movie;
import com.movie.entity.Review;
import com.movie.entity.User;
import com.movie.repository.MovieRepository;
import com.movie.repository.ReviewRepository;
import com.movie.repository.UserRepository;
import com.movie.request.ReviewRequest;
import com.movie.response.ReviewResponse;
import com.movie.service.ReviewService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImplementation implements ReviewService {
    private static final Logger log = LoggerFactory.getLogger(ReviewServiceImplementation.class);

    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    private final ModelMapper modelMapper;

    public ReviewServiceImplementation(final ReviewRepository reviewRepository, final UserRepository userRepository, final MovieRepository movieRepository, final ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReviewResponse createReview(@Valid ReviewRequest reviewRequest, String userId, Long movieId) {
        if (reviewRequest.getRatingValue() < SystemConstants.MIN_RATING || reviewRequest.getRatingValue() > SystemConstants.MAX_RATING) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(ErrorMessages.VALID_RATING_RANGE, SystemConstants.MIN_RATING, SystemConstants.MAX_RATING));
        }

        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %S not found", userId)));

        Movie movie = this.movieRepository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", movieId)));

        Review review = this.modelMapper.map(reviewRequest, Review.class);
        review.setUser(user);
        review.setMovie(movie);
        review.setRatingValue((Math.round(reviewRequest.getRatingValue() * 10) / 10.0f));
        return this.modelMapper.map(this.reviewRepository.save(review), ReviewResponse.class);
    }

    @Override
    public ReviewResponse getReviewByReviewId(Long reviewId) {
        return this.modelMapper.map(this.reviewRepository.findById(reviewId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Review with id %d not found", reviewId))), ReviewResponse.class);
    }

    @Override
    public List<ReviewResponse> getAllReviews() {
        return this.reviewRepository.findAll().stream().map(s -> this.modelMapper.map(s, ReviewResponse.class)).collect(Collectors.toList());

    }

    @Override
    public List<ReviewResponse> getReviewsByMovieId(Long movieId) {
        Movie movie = this.movieRepository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", movieId)));

        return this.reviewRepository.findByMovie(movie).stream().map(s -> this.modelMapper.map(s, ReviewResponse.class)).collect(Collectors.toList());
    }

}
