package com.movie.response;

public class CustomResponse {
    private String message;
    private ShowDetailsResponse showDetailsResponse;

    public CustomResponse(String message, ShowDetailsResponse showDetailsResponse) {
        this.message = message;
        this.showDetailsResponse = showDetailsResponse;
    }

    public CustomResponse() {
    }

    public String getMessage() {
        return this.message;
    }

    public ShowDetailsResponse getShowDetailsResponse() {
        return this.showDetailsResponse;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setShowDetailsResponse(ShowDetailsResponse showDetailsResponse) {
        this.showDetailsResponse = showDetailsResponse;
    }

    public String toString() {
        return "CustomResponse(message=" + this.getMessage() + ", showDetailsResponse=" + this.getShowDetailsResponse() + ")";
    }
}