package com.movie.service.serviceImplementation;

import com.movie.entity.Movie;
import com.movie.entity.Screen;
import com.movie.entity.ShowDetails;
import com.movie.entity.Theater;
import com.movie.repository.*;
import com.movie.request.ShowDetailsRequest;
import com.movie.response.ShowDetailsResponse;
import com.movie.service.ShowDetailsService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShowDetailsServiceImplementation implements ShowDetailsService {
    private static final Logger log = LoggerFactory.getLogger(ShowDetailsServiceImplementation.class);

    private final ShowDetailsRepository showDetailsRepository;
    private final TheaterRepository theaterRepository;
    private final ScreenRepository screenRepository;
    private final MovieRepository movieRepository;
    private final SeatRepository seatRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ShowDetailsServiceImplementation(final ShowDetailsRepository showDetailsRepository, final TheaterRepository theaterRepository, final ScreenRepository screenRepository, final MovieRepository movieRepository, final SeatRepository seatRepository, final ModelMapper modelMapper) {
        this.showDetailsRepository = showDetailsRepository;
        this.theaterRepository = theaterRepository;
        this.screenRepository = screenRepository;
        this.movieRepository = movieRepository;
        this.seatRepository = seatRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ShowDetailsResponse createShowDetails(ShowDetailsRequest showDetailsRequest, Long movieId, Long theaterId, Long screenId) {
        Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Theater with id %d not found", theaterId)));

        Movie movie = this.movieRepository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", movieId)));

        Screen screen = this.screenRepository.findById(screenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Screen with id %d not found", screenId)));

        List<ShowDetails> listOfScheduledShows = this.showDetailsByScreenId(theaterId, screenId).stream().map(s -> this.modelMapper.map(s, ShowDetails.class)).collect(Collectors.toList());

        LocalDateTime freeTimeStart = LocalDateTime.now();

        Boolean duplicateShowPresent = false;

        if (!listOfScheduledShows.isEmpty()) {
            listOfScheduledShows.sort(Comparator.comparing(ShowDetails::getShowTime));
            ShowDetails latestShow = listOfScheduledShows.get(listOfScheduledShows.size() - 1);
            freeTimeStart = this.calculateFreeTimeStart(latestShow.getShowTime(), latestShow.getMovie().getDuration());
            duplicateShowPresent = this.showDetailsRepository.isDuplicate(theaterId, showDetailsRequest.getShowTime());
        }
        ShowDetails savedShowDetails;

        if (duplicateShowPresent && (freeTimeStart.isBefore(showDetailsRequest.getShowTime()) || listOfScheduledShows.isEmpty())) {
            System.out.println("test free time lof" + freeTimeStart);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Duplicate ShowTime: For screen: [%s] in theater Id:[%d] : Existing show Time[%s] ", screen.getScreenName(), theater.getTheaterId(), showDetailsRequest.getShowTime()));
        } else {
            ShowDetails showDetails = this.modelMapper.map(showDetailsRequest, ShowDetails.class);
            if (showDetailsRequest.getShowTime().isBefore(LocalDateTime.now())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(" Invalid Request: Show Schedule attempt for past[%s] for movie: [%s]", showDetailsRequest.getShowTime(), showDetailsRequest.getMovie()));
            } else if (movie.getReleaseDate().isAfter(showDetailsRequest.getShowTime())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Illegal attempt::Trying to schedule movie on [%s]  before release[%s] for movie: [%s]", showDetailsRequest.getShowTime(), movie.getReleaseDate(), showDetailsRequest.getMovie()));

            } else {
                showDetails.setMovie(movie);
                screen.resetSeats();
                // reset the seatStatus as: available for new show
                Screen savedScreen = this.screenRepository.save(screen);

                showDetails.setAvailableSeats(screen.getSeatsCapacity());
                showDetails.setBookedSeats(0L);
                showDetails.setTotalSeats(screen.getSeatsCapacity());
                showDetails.setScreen(savedScreen);
                showDetails.setBoooking(Collections.emptyList());
                savedShowDetails = this.showDetailsRepository.save(showDetails);

            }
        }

        return this.modelMapper.map(savedShowDetails, ShowDetailsResponse.class);
    }

    @Override
    public ShowDetailsResponse getShowDetailsByShowDetailsId(Long showDetailsId) {
        ShowDetails showDetails = this.showDetailsRepository.findById(showDetailsId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("show Details: with id %d not found", showDetailsId)));
        return this.modelMapper.map(showDetails, ShowDetailsResponse.class);
    }

    @Override
    public List<ShowDetailsResponse> getAllShowDetailsByTheaterId(Long theaterId) {
        Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Theater : with id %d not found", theaterId)));
        Set<ShowDetails> ShowDetailList = new HashSet<>();
        for (Screen screen : theater.getScreen()) {
            Set<ShowDetails> showDetail = this.showDetailsRepository.findByScreen(screen);
            if (showDetail != null) ShowDetailList.addAll(showDetail);
        }
        return ShowDetailList.stream().map(s -> this.modelMapper.map(s, ShowDetailsResponse.class)).collect(Collectors.toList());

    }

    @Override
    public void deleteShowDetails(Long showDetailsId) {
        this.getShowDetailsByShowDetailsId(showDetailsId);
        this.showDetailsRepository.deleteById(showDetailsId);

    }

    @Override
    public List<ShowDetailsResponse> showDetailsByScreenId(Long theaterId, Long screenId) {
        Theater theater = this.theaterRepository.findById(theaterId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Theater with id %d not found", theaterId)));
        Screen screen = this.screenRepository.findById(screenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Screen with id %d not found", screenId)));

        Set<ShowDetails> showDetail = this.showDetailsRepository.findByScreen(screen);

        return showDetail.stream().map(s -> this.modelMapper.map(s, ShowDetailsResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShowDetailsResponse> getShowDetailsByMovieId(Long movieId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ShowDetailsResponse> getAllShowDetails() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteShowDetails(Integer showDetailsId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<ShowDetailsResponse> getShowDetailsByMovieId(Integer movieId) {
        // TODO Auto-generated method stub
        return null;
    }

    public LocalDateTime calculateFreeTimeStart(LocalDateTime startDateTime, int durationInMinutes) {
        Duration duration = Duration.ofMinutes(durationInMinutes);
        // Calculate end time
        LocalDateTime endDateTime = startDateTime.plus(duration);
        // If end time is after 11.59 PM, move to next day
        if (endDateTime.toLocalTime().isAfter(LocalTime.of(23, 59))) {
            endDateTime = endDateTime.plusDays(1).with(LocalTime.MIN); // Set to next day's start time
        }

        // Create the free time interval
        LocalDateTime freeTimeStart = endDateTime.plusMinutes(15);
        System.out.println("free time:" + freeTimeStart);
        return freeTimeStart;
    }

}
