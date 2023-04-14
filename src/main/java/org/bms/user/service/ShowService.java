package org.bms.user.service;

import org.bms.model.SeatType;
import org.bms.model.ShowSeat;
import org.bms.model.ShowSeatType;
import org.bms.model.Shows;

import java.util.List;
import java.util.Map;

public interface ShowService {
    Shows save(Shows show,  Map<SeatType, Double> seatTypes);

    ShowSeat saveShowSeat(ShowSeat showSeat);
    List<ShowSeat> saveShowSeat(List<ShowSeat> showSeat);

    ShowSeatType saveShowSeatType(ShowSeatType showSeatType);
}
