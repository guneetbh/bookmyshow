package org.bms.user.service;

import org.bms.model.Seats;
import org.bms.model.ShowSeat;
import org.bms.model.ShowSeatType;
import org.bms.model.Shows;
import org.bms.user.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingPriceCalculator {

    private ShowSeatTypeRepository showSeatTypeRepository;
@Autowired
    public BookingPriceCalculator(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculateBookingPrice(List<ShowSeat> showSeats) {
        Shows show = showSeats.get(0).getShows();
        // Get showSeat Types for this show
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShowsEquals(show);
        double amount = 0.0;
        //Get the price for show seat
        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType: showSeatTypes) {
                if (showSeat.getSeats().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                }
            }
        }
        return  amount;
    }
}
