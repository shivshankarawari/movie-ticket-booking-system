package com.movie.service;

import java.util.List;
import java.util.Set;

import com.movie.request.ScreenRequest;
import com.movie.response.ScreenResponse;

import jakarta.validation.Valid;

public interface ScreenService {

    // super-admin
    ScreenResponse createScreenInTheater(@Valid ScreenRequest screenRequest, Long TheaterId);

    // user/amdin/superaddmin
    List<ScreenResponse> getAllScreensInTheater(Long theterId);

    ScreenResponse getScreenByScreenId(Long ScreenId);

    // admin
    ScreenResponse updateScreen(ScreenRequest screenRequest, Long theterId, Long screenId);

    // superadmin/ admin
    void deleteScreenByScreenId(Long screenId);

}
