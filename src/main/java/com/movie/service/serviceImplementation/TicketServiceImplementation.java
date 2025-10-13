package com.movie.service.serviceImplementation;

import com.movie.entity.Booking;
import com.movie.entity.Seat;
import com.movie.entity.Ticket;
import com.movie.request.BookingRequest;
import com.movie.response.PrintTicketResponse;
import com.movie.service.BookingService;
import com.movie.service.TicketService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.StringJoiner;

import static java.lang.System.*;

@Service
public class TicketServiceImplementation implements TicketService {
    private static final Logger log = LoggerFactory.getLogger(TicketServiceImplementation.class);
    private final BookingService bookingService;
    private final ModelMapper modelMapper;

    @Autowired
    public TicketServiceImplementation(final BookingService bookingService, final ModelMapper modelMapper) {
        this.bookingService = bookingService;
        this.modelMapper = modelMapper;
    }


    @Override
    public PrintTicketResponse printTicketData(Long bookingId) {

        Booking bookingDetails = this.modelMapper.map(this.bookingService.getBookingByBookingId(bookingId), Booking.class);

        PrintTicketResponse printTicketResponse = new PrintTicketResponse();

        List<Ticket> myTicketData = bookingDetails.getTicket();
        StringJoiner sj = new StringJoiner(", ");
        if (myTicketData == null || myTicketData.isEmpty()) {
            out.println("No tickets found.");
        } else {
            for (Ticket ticket : myTicketData) {
                sj.add(ticket.getSeatNumber());
            }
            out.println("Seat numbers: " + sj);
        }

        // format the theater address
        // create a new College object

        StringJoiner stringAddress = new StringJoiner(", ");
        stringAddress.add(bookingDetails.getShowDetails().getScreen().getTheater().getStreet());
        stringAddress.add(bookingDetails.getShowDetails().getScreen().getTheater().getCity());
        stringAddress.add(bookingDetails.getShowDetails().getScreen().getTheater().getZip());
        stringAddress.add(bookingDetails.getShowDetails().getScreen().getTheater().getState());
        stringAddress.add(".");

        // date and time formating
        LocalDateTime showDateTime = bookingDetails.getShowDetails().getShowTime();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = showDateTime.format(dateFormatter);
        String formattedTime = showDateTime.format(timeFormatter);

        // printing ticket data..
        printTicketResponse.setBookingId(bookingDetails.getBookingId());
        printTicketResponse.setListOfSeats(sj.toString());
        printTicketResponse.setMovieFormat(bookingDetails.getShowDetails().getMovieFormat());
        printTicketResponse.setMovieLanguage(bookingDetails.getShowDetails().getMovieLanguage());
        printTicketResponse.setMovieName(bookingDetails.getShowDetails().getMovie().getMovieName());
        printTicketResponse.setScreenName(bookingDetails.getShowDetails().getScreen().getScreenName());
        printTicketResponse.setShowDate(formattedDate);
        printTicketResponse.setShowStartTime(formattedTime);
        printTicketResponse.setTheaterAddress(stringAddress.toString());
        return printTicketResponse;
    }

    @Override
    public List<Seat> createTicket(BookingRequest bookingRequest) {
        // TODO Auto-generated method stub
        return null;
    }

//	@Override
//	public List<Seat> createTicket(BookingRequest bookingRequest) {
//
//		List<Seat> selectedSeats = bookingRequest.getShowDetails().getScreen().getSeat();
//		for (Seat s : selectedSeats) {
//			Ticket ticket = new Ticket();
//			ticket.setBooking(this.modelMapper.map(bookingRequest, Booking.class));
//			bookingRequest.getTicketCount(bookingRequest.getSeat().size());
//			ticket.setPrice(bookingRequest.getPayment().getTotalAmount());
//			ticket.setSeatNumber(null);
//
//			this.ticketRepository.save(ticket);
//		}
//		for(int =0; i<=)
//		return null;
//	}

}
