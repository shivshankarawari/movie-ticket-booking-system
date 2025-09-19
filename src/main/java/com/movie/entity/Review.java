package com.movie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(name = "rating_value", nullable = false)
    private Float ratingValue;

    @Column(name = "user_comment", nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    // Cascade type need to check
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    // Cascade type need to check
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review(Long reviewId, Float ratingValue, String comment, User user, Movie movie) {
        this.reviewId = reviewId;
        this.ratingValue = ratingValue;
        this.comment = comment;
        this.user = user;
        this.movie = movie;
    }

    public Review() {
    }

    public Long getReviewId() {
        return this.reviewId;
    }

    public Float getRatingValue() {
        return this.ratingValue;
    }

    public String getComment() {
        return this.comment;
    }

    public User getUser() {
        return this.user;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public void setRatingValue(Float ratingValue) {
        this.ratingValue = ratingValue;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
