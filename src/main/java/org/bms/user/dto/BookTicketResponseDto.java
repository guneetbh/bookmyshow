package org.bms.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.bms.model.Booking;
@Getter
@Setter
public class
BookTicketResponseDto {
    private String status;

    private Booking booking;
}
