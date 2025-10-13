package com.movie.service.serviceImplementation;

import com.movie.entity.Screen;
import com.movie.entity.Seat;
import com.movie.entity.Theater;
import com.movie.repository.ScreenRepository;
import com.movie.repository.SeatRepository;
import com.movie.repository.TheaterRepository;
import com.movie.request.SeatRequest;
import com.movie.response.SeatResponse;
import com.movie.service.SeatService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImplementation implements SeatService {
    private static final Logger log = LoggerFactory.getLogger(SeatServiceImplementation.class);


    private final SeatRepository seatRepository;
    private final TheaterRepository theaterRepository;
    private final ScreenRepository screenRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SeatServiceImplementation(final SeatRepository seatRepository, final TheaterRepository theaterRepository, final ScreenRepository screenRepository, final ModelMapper modelMapper) {
        this.seatRepository = seatRepository;
        this.theaterRepository = theaterRepository;
        this.screenRepository = screenRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SeatResponse> addSeatsInScreen(@Valid List<SeatRequest> seatRequest, Long theaterId, Long screenId) {
        Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Theater with id %d not found", theaterId)));

        Screen screen = this.screenRepository.findById(screenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Screen with id %d not found", screenId)));
        List<Seat> savedSeats;
        if ((seatRequest.size() + this.getAllSeatsInSpecificScreen(theaterId, screenId).size()) <= screen.getSeatsCapacity()) {

            seatRequest.forEach(s -> s.setScreen(screen));

            List<Seat> seatList = seatRequest.stream().map(source -> this.modelMapper.map(source, Seat.class)).collect(Collectors.toList());
            savedSeats = seatRepository.saveAll(seatList);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Max Seat-capacitY is [%d] for screen:ID:[%d] in theater:ID:[%d] exceeding", screen.getSeatsCapacity(), screenId, theaterId));
        }

        return savedSeats.stream().map(source -> this.modelMapper.map(source, SeatResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<SeatResponse> getAllSeatsInTheater(Long theaterId, Long screenId) {
        Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Theater with id %d not found", theaterId)));
        Screen screen = this.screenRepository.findById(screenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Screen with id %d not found", screenId)));

        return null;
    }

    public SeatResponse updateSeatsInSpecificScreen(SeatRequest seatRequest, Long theaterId, Long screenId) {
        Seat seat = this.modelMapper.map(seatRequest, Seat.class);
        Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Theater with id %d not found", theaterId)));

        Screen screen = this.screenRepository.findById(screenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Screen with id %d not found", screenId)));
        return null;
    }

    @Override
    public SeatResponse getSeatBySeatId(Long seatId) {
        Seat seat = this.seatRepository.findById(seatId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Screen with id %d not found", seatId)));
        return this.modelMapper.map(seat, SeatResponse.class);
    }

    @Override
    public List<SeatResponse> getAllSeatsInSpecificScreen(Long theaterId, Long screenId) {
        Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Theater with id %d not found", theaterId)));

        Screen screen = this.screenRepository.findById(screenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Screen with id %d not found", screenId)));
        List<Seat> seats = this.seatRepository.findByScreen(screen);

        return seats.stream().map(s -> this.modelMapper.map(s, SeatResponse.class)).collect(Collectors.toList());

    }

}
