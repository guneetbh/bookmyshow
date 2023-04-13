package org.bms.user.service;

import org.bms.exceptions.SeatNotAvailableException;
import org.bms.model.Booking;
import org.bms.model.User;
import org.bms.user.dto.BookTicketResponseDto;

import java.util.List;

public interface BookingService {

    public Booking bookTicket(Long showId, List<Long> showSeatsId, Long user) throws SeatNotAvailableException;
}
