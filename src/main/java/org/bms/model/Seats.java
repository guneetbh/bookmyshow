package org.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seats extends BaseModel{
   // private int seatId;
    private String seatName;
    @ManyToOne
    //@JoinColumn(name = "seat_type_id")
    private SeatType seatType;

    public Seats() {
    }

    private int seatRow;
    private int seatColumn;

    public Seats(int seatColumn, String seatName, int seatRow, SeatType seatType) {
        super();
        this.seatColumn = seatColumn;
        this.seatName = seatName;
        this.seatRow = seatRow;
        this.seatType = seatType;

    }
}
