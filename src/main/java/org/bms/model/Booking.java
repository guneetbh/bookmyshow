package org.bms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Booking  extends BaseModel{
   // private int ticketId;
    @ManyToOne
    private Shows shows;

    @OneToMany
    private List<Payment> payments;
    private double amount;
    @ManyToMany
    private List<ShowSeat> showSeats;

    @OneToOne
    private User bookedBy;
    private Date bookingTime;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
}
