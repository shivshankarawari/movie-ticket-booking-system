package com.movie.service;

import java.util.List;

import com.movie.request.ShowDetailsRequest;
import com.movie.response.ShowDetailsResponse;

import jakarta.validation.Valid;

public interface ShowDetailsService {

    ShowDetailsResponse createShowDetails(@Valid ShowDetailsRequest showDetailsRequest, Long movieId, Long theaterId,
                                          Long screenId);

    ShowDetailsResponse getShowDetailsByShowDetailsId(Long showDetailsId);

    List<ShowDetailsResponse> getAllShowDetailsByTheaterId(Long theaterId);

    void deleteShowDetails(Long showDetailsId);

    //ShowDetailsResponse upateShowDetails(@Valid ShowDetailsResponse showDetailsRequest, Long showDetailsId);

    List<ShowDetailsResponse> getShowDetailsByMovieId(Long movieId);

    List<ShowDetailsResponse> getAllShowDetails();

    List<ShowDetailsResponse> showDetailsByScreenId(Long theaterId, Long screenId);



    void deleteShowDetails(Integer showDetailsId);

    List<ShowDetailsResponse> getShowDetailsByMovieId(Integer movieId);

    // search nearbyshow by keyword: //today and tomm.

}
