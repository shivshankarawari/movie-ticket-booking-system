package com.movie.response;

public class NearByTheaterResponse {
    private String distanceFromUser;
    private String TimeToReach;
    private String customMessage;
    private TheaterResponse theaterResponse;

    public NearByTheaterResponse(String distanceFromUser, String TimeToReach, String customMessage, TheaterResponse theaterResponse) {
        this.distanceFromUser = distanceFromUser;
        this.TimeToReach = TimeToReach;
        this.customMessage = customMessage;
        this.theaterResponse = theaterResponse;
    }

    public NearByTheaterResponse() {
    }

    public String getDistanceFromUser() {
        return this.distanceFromUser;
    }

    public String getTimeToReach() {
        return this.TimeToReach;
    }

    public String getCustomMessage() {
        return this.customMessage;
    }

    public TheaterResponse getTheaterResponse() {
        return this.theaterResponse;
    }

    public void setDistanceFromUser(String distanceFromUser) {
        this.distanceFromUser = distanceFromUser;
    }

    public void setTimeToReach(String TimeToReach) {
        this.TimeToReach = TimeToReach;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public void setTheaterResponse(TheaterResponse theaterResponse) {
        this.theaterResponse = theaterResponse;
    }

    public String toString() {
        return "NearByTheaterResponse(distanceFromUser=" + this.getDistanceFromUser() + ", TimeToReach=" + this.getTimeToReach() + ", customMessage=" + this.getCustomMessage() + ", theaterResponse=" + this.getTheaterResponse() + ")";
    }
}
