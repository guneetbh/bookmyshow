package org.bms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
public class ShowSeat extends BaseModel{
    @ManyToOne
   //@JoinColumn(name = "show_id")
    private Shows shows;
    @ManyToOne
   // @JoinColumn(name = "seats_id")
    private Seats seats;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;

    public ShowSeat() {
        
    }

    public ShowSeat(ShowSeatStatus seatStatus,  Seats seat, Shows show) {
        super();
this.showSeatStatus = seatStatus;
this.shows = show;
this.seats = seat;
    }
}
