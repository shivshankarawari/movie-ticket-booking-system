package com.movie.service.serviceImplementation;

import com.movie.entity.*;
import com.movie.enums.BookingStatus;
import com.movie.enums.SeatStatus;
import com.movie.repository.*;
import com.movie.request.BookingRequest;
import com.movie.response.BookingResponse;
import com.movie.service.BookingService;
import com.movie.service.PaymentService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookingServiceImplementation implements BookingService {
    private static final Logger log = LoggerFactory.getLogger(BookingServiceImplementation.class);
    private final ShowDetailsRepository showDetailsRepository;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final PaymentService paymentService;
    private final SeatRepository seatRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BookingServiceImplementation(final ShowDetailsRepository showDetailsRepository, final BookingRepository bookingRepository, final UserRepository userRepository, final TicketRepository ticketRepository, final PaymentService paymentService, final SeatRepository seatRepository, final ModelMapper modelMapper) {
        this.showDetailsRepository = showDetailsRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.paymentService = paymentService;
        this.seatRepository = seatRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest, Long showId, String userId) {
        ShowDetails showDetails = this.showDetailsRepository.findById(showId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("show Details: with id %d not found", showId)));
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %S not found", userId)));
        System.out.println("CONTROL:" + 1);
        Long availableSeatCount = showDetails.getAvailableSeats();

        // rewrite this
//		List<Seat> seats = showDetails.getScreen().getSeat();
//		System.out.println("Seats present"+seats.toString());
//		if (seats.size() != bookingRequest.getTicketCount()) {
//			throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,
//					String.format("Some of the requested seats are not available", 0));
//		}
        // write better logic for the seats not available.
        if (availableSeatCount < bookingRequest.getSeat().size()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Selected Seats not available");
        }
        System.out.println("CONTROL:" + 2);
        Booking booking = this.modelMapper.map(bookingRequest, Booking.class);
        Payment paymentconfirmed = paymentService.createPayement(booking, booking.getPayment().getPaymentMode(), booking.getPayment().getTotalAmount());
        System.out.println("CONTROL:" + 3);
        if (paymentconfirmed != null) {
            booking.setBookingStatus(BookingStatus.CONFIRMED);
        } else {
            booking.setBookingStatus(BookingStatus.FAILED);
        }
        System.out.println("CONTROL:" + 4);

        booking.setShowDetails(showDetails);
        booking.setUser(user);
        //booking.setBookingTime(LocalDateTime.now());
        booking.setPayment(paymentconfirmed);
        booking.setBookingTime(LocalDateTime.now());
        System.out.println("CONTROL:" + 5);
        ArrayList<Seat> reservedSeats = new ArrayList<>();
        booking.setTicketCount(bookingRequest.getSeat().size());
        // update seat status as reserved after the payment
        for (Seat seat : bookingRequest.getSeat()) {
            Seat foundSeat = this.seatRepository.findById(seat.getSeatId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Seat with id %d not found", seat.getSeatId())));

            foundSeat.setStatus(SeatStatus.RESERVED);
            reservedSeats.add(foundSeat);
            Ticket ticket = new Ticket();
            ticket.setBooking(booking);
            ticket.setPrice(200);
            ticket.setSeatNumber(foundSeat.getSeatNumber());
            this.ticketRepository.save(ticket);
        }
        final List<Seat> seats = this.seatRepository.saveAll(reservedSeats);
        Booking savedBooking = this.bookingRepository.save(booking);
        showDetails.setAvailableSeats(showDetails.getTotalSeats() - bookingRequest.getSeat().size());
        this.showDetailsRepository.save(showDetails);
        BookingResponse bookingResponse = this.modelMapper.map(savedBooking, BookingResponse.class);
        bookingResponse.setSeat(Collections.unmodifiableList(reservedSeats));
        return bookingResponse;
    }

    @Override
    public BookingResponse updateBooking(BookingRequest bookingRequest, Long bookingId) {
        return null;
    }

    @Override
    public List<BookingResponse> getAllBookingsForUser(String emailId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Booking getBookingByBookingId(Long bookingId) {
        return this.bookingRepository.findById(bookingId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("booking Details: with id %d not found", bookingId)));
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Booking booking = this.getBookingByBookingId(bookingId);
        ShowDetails showDetails = this.showDetailsRepository.findById((long) booking.getShowDetails().getShowId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid cancelation request: for movie with id %s not found", booking.getShowDetails().getMovie().getMovieName())));

        showDetails.setAvailableSeats(showDetails.getAvailableSeats() + booking.getTicketCount());
        this.showDetailsRepository.save(showDetails);

        ArrayList<Seat> reservedSeats = new ArrayList<>();
        for (Seat seat : booking.getShowDetails().getScreen().getSeat()) {
            Seat foundSeat = this.seatRepository.findById(seat.getSeatId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Seat with id %d not found", seat.getSeatId())));

            foundSeat.setStatus(SeatStatus.AVAILABLE);
            reservedSeats.add(foundSeat);
        }
        this.seatRepository.saveAll(reservedSeats);
        this.bookingRepository.deleteById(bookingId);

    }

}
