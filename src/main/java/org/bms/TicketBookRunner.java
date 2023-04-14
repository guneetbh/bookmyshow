package org.bms;

import org.bms.user.controller.BookingController;
import org.bms.user.dto.BookTicketRequestDto;
import org.bms.user.dto.BookTicketResponseDto;

import java.util.List;

public class TicketBookRunner implements  Runnable{
    private BookingController bookingController;
    private Long showId;
    private List<Long> showSeatId;
    private Long userId;

    public TicketBookRunner(BookingController bookingController,
                            Long showId,
                            List<Long> showSeatId,
                            Long userId) {
        this.bookingController = bookingController;
        this.showId = showId;
        this.showSeatId = showSeatId;
        this.userId = userId;
    }
    @Override
    public void run() {
        try {
            BookTicketRequestDto requestDto = new BookTicketRequestDto();
            requestDto.setUserId(userId);
            requestDto.setShowId(showId);
            requestDto.setShowSeatIds(showSeatId);
            BookTicketResponseDto responseDto =this.bookingController.bookTicket(
                    requestDto
            );
            if(null == responseDto.getBooking()){
                throw new Exception();
               // System.out.println("Booking for same seats cannot be done. Please choose other seat and try again");
           }
            System.out.println("Seats booked for userId: "+userId);
            responseDto.getBooking().getShowSeats().stream().forEach(seat -> System.out.print(" | "+seat.getSeats().getSeatName()));
            System.out.println("\n");
        } catch (Exception exception) {
            System.out.println("EXCEPTION: Booking for same seats cannot be done. Please choose other seat and try again");
        }

    }
}
