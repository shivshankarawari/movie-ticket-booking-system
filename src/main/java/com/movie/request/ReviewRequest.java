package com.movie.request;

import com.movie.entity.Movie;
import com.movie.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    private Long reviewId;
    //@Pattern(regexp = "^[1-9]|10$",message = "Rating value should in range 1 to 10. !")
    private Float ratingValue;

    private String comment;

    private User user;

    private Movie movie;

//    public ReviewRequest(Long reviewId, Float ratingValue, String comment, User user, Movie movie) {
//        this.reviewId = reviewId;
//        this.ratingValue = ratingValue;
//        this.comment = comment;
//        this.user = user;
//        this.movie = movie;
//    }
//
//    public ReviewRequest() {
//    }
//
//    public Long getReviewId() {
//        return this.reviewId;
//    }
//
//    public Float getRatingValue() {
//        return this.ratingValue;
//    }
//
//    public String getComment() {
//        return this.comment;
//    }
//
//    public User getUser() {
//        return this.user;
//    }
//
//    public Movie getMovie() {
//        return this.movie;
//    }
//
//    public void setReviewId(Long reviewId) {
//        this.reviewId = reviewId;
//    }
//
//    public void setRatingValue(Float ratingValue) {
//        this.ratingValue = ratingValue;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }
//
//    public String toString() {
//        return "ReviewRequest(reviewId=" + this.getReviewId() + ", ratingValue=" + this.getRatingValue() + ", comment=" + this.getComment() + ", user=" + this.getUser() + ", movie=" + this.getMovie() + ")";
//    }
}
