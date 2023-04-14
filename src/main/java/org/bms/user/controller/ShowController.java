package org.bms.user.controller;

import org.bms.model.SeatType;
import org.bms.model.ShowSeat;
import org.bms.model.ShowSeatType;
import org.bms.model.Shows;
import org.bms.user.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class ShowController {
       private  ShowService showService;

        @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    public Shows createShow(Shows show, Map<SeatType, Double> seatTypes) {
        return showService.save(show, seatTypes);
    }

    public ShowSeat saveShowSeat(ShowSeat showSeat) {
        return showService.saveShowSeat(showSeat);
    }

    public List<ShowSeat> saveShowSeat(List<ShowSeat> showSeat) {
        return showService.saveShowSeat(showSeat);
    }
    public ShowSeatType createShowSeats(ShowSeatType showSeatType) {
            return  showService.saveShowSeatType(showSeatType);
    }
}
