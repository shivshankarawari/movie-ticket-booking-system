package com.movie.controller;

import com.movie.exception.ApiResponse;
import com.movie.request.ScreenRequest;
import com.movie.response.ScreenResponse;
import com.movie.service.ScreenService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/screens")
public class ScreenController {
    private static final Logger logger = LoggerFactory.getLogger(ScreenController.class);
    /*
     * //this will be useful for theater admins PUT
     * /theaters/{id}/screens/{screenId}: Updates a specific screen for a specific
     * theater by ID DELETE /theaters/{id}/screens/{screenId}: Deletes a specific
     * screen for a specific theater by ID
     *
     */

    private final ScreenService screenService;

    @Autowired
    public ScreenController(final ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping("/theater/{theaterId}/create/")
    public ResponseEntity<ScreenResponse> createScreenInTheater(@Valid @RequestBody ScreenRequest screenRequest,
                                                                @PathVariable Long theaterId) {
        return new ResponseEntity<>(this.screenService.createScreenInTheater(screenRequest, theaterId),
                HttpStatus.CREATED);
    }

    @GetMapping("/search/by-theater/{theaterId}")
    public ResponseEntity<List<ScreenResponse>> getAllScreensInTheater(@PathVariable Long theaterId) {
        return new ResponseEntity<List<ScreenResponse>>(this.screenService.getAllScreensInTheater(theaterId),
                HttpStatus.OK);

    }

    @GetMapping("/{screenId}")
    public ResponseEntity<ScreenResponse> getScreenByScreenId(@PathVariable Long screenId) {
        return new ResponseEntity<>(this.screenService.getScreenByScreenId(screenId), HttpStatus.CREATED);
    }

    @PutMapping("/theater/{theaterId}/screens/{screenId}")
    public ResponseEntity<ScreenResponse> updateScreen(@RequestBody ScreenRequest screenRequest,
                                                       @PathVariable Long theaterId, @PathVariable Long screenId) {
        return new ResponseEntity<>(this.screenService.updateScreen(screenRequest, theaterId, screenId),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{screenId}")
    public ResponseEntity<ApiResponse> deleteScreenByScreenId(@PathVariable Long screenId) {
        this.screenService.deleteScreenByScreenId(screenId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Movie Deleted Successfully", true), HttpStatus.OK);
    }
}
