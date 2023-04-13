package org.bms.user.controller;


import org.bms.exceptions.SeatNotAvailableException;
import org.bms.model.Booking;
import org.bms.model.Movie;
import org.bms.user.dto.BookTicketRequestDto;
import org.bms.user.dto.BookTicketResponseDto;
import org.bms.user.dto.TheatreRequestDto;
import org.bms.user.dto.TheatreResponseDto;
import org.bms.user.service.BookingService;
import org.bms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {

    UserService userService;

    @Autowired
    public BookingController(UserService userService, BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
    }

    BookingService bookingService;


    //Get movies by cities, language and genres
    public List<Movie> fetchMovies(String city){
        List<Movie> movies = userService.fetchMovie(city);
        return movies;
    }
    //get theatres by movie in the given city by chosen date
    public TheatreResponseDto fetchMovieTheatres(TheatreRequestDto theatreRequestDto){
          return  userService.fetchMovieTheatres(theatreRequestDto);
    }
    //Book ticket
    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto){
            try {
                Booking booking = bookingService.bookTicket(bookTicketRequestDto.getShowId(),
                        bookTicketRequestDto.getShowSeatIds(), bookTicketRequestDto.getUserId());
                BookTicketResponseDto responseDto = new BookTicketResponseDto();
                responseDto.setStatus("SUCCESS");
                responseDto.setBooking(booking);
                return responseDto;
            }catch (SeatNotAvailableException sa){
                sa.getMessage();
                BookTicketResponseDto responseDto = new BookTicketResponseDto();
                responseDto.setStatus("FAILED");
                return responseDto;
            }
    }
}
