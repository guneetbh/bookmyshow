package org.bms.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookTicketRequestDto {
//    public String theatre;
//    public String timing;
//    public String seats;

    private Long showId;
    private List<Long> showSeatIds;
    private Long userId;
}
