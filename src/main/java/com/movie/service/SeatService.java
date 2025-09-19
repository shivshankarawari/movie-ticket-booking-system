package com.movie.service;

import java.util.List;

import com.movie.request.SeatRequest;
import com.movie.response.SeatResponse;

import jakarta.validation.Valid;

public interface SeatService {

    List<SeatResponse> addSeatsInScreen(@Valid List<SeatRequest> seatRequest, Long theaterId, Long screenId);

    SeatResponse updateSeatsInSpecificScreen(SeatRequest seatRequest, Long theaterId, Long ScreenId);

    SeatResponse getSeatBySeatId(Long SeatId);

    List<SeatResponse> getAllSeatsInTheater(Long theaterId, Long screenId);

    List<SeatResponse> getAllSeatsInSpecificScreen(Long theaterId, Long screenId);


}
