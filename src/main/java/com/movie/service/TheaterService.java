package com.movie.service;

import java.util.List;

import com.movie.request.TheaterRequest;
import com.movie.response.NearByTheaterResponse;
import com.movie.response.TheaterResponse;

import jakarta.validation.Valid;

public interface TheaterService {

    TheaterResponse createTheater(TheaterRequest theaterResponse);

    List<TheaterResponse> getTheaterByKeyword(String keyword);

    TheaterResponse getTheaterByTheaterId(Long theaterId);

    List<NearByTheaterResponse> getNearByTheater(Double latitude, Double longitude, Double radius);

    List<TheaterResponse> getAllTheatres();

    TheaterResponse upateTheater(TheaterRequest theaterRequest, @Valid Long theaterId);

    void deleteTheater(Long theaterId);

}
