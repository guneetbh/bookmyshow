package org.bms.user.service.impl;

import org.bms.exceptions.EntityNotFoundException;
import org.bms.exceptions.SeatNotAvailableException;
import org.bms.model.*;
import org.bms.user.dto.BookTicketResponseDto;
import org.bms.user.repositories.BookingRepository;
import org.bms.user.repositories.ShowSeatRepository;
import org.bms.user.repositories.ShowsRepository;
import org.bms.user.repositories.UserRepository;
import org.bms.user.service.BookingPriceCalculator;
import org.bms.user.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    private UserRepository userRepository;
   private ShowsRepository showsRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingPriceCalculator bookingPriceCalculator;

    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(ShowsRepository showsRepository,  ShowSeatRepository showSeatRepository,
                              BookingPriceCalculator bookingPriceCalculator,
                              BookingRepository bookingRepository,
                              UserRepository userRepository){
        this.showsRepository = showsRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.bookingPriceCalculator = bookingPriceCalculator;
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long showId, List<Long> showSeatsId, Long userId) throws SeatNotAvailableException {
        //get the user
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Usr not found for ID:"+userId));
        // get the show details
        Shows show = showsRepository.findByIdEquals(showId);
        // get the show Seats for the mentioned ID
        List<ShowSeat> showSeats =  showSeatRepository.findAllByIdIn(showSeatsId);
        // check if seats are available
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("Show seats "+ showSeat.getId() +" is not available for booking");
            }
        }
        // if available -
        //      set status to locked
        for(ShowSeat showSeat : showSeats){
           showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
           showSeatRepository.save(showSeat);
        }
        // create the ticket and save to DB
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        booking.setBookedBy(user);
        booking.setBookingTime(new Date());
        booking.setShows(show);
        booking.setShowSeats(showSeats);
        booking.setAmount(bookingPriceCalculator.calculateBookingPrice(showSeats));
        // respond with booking detail
        Booking book = bookingRepository.save(booking);

        return book;
    }


}
