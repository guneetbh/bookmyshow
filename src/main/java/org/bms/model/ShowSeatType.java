package org.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ShowSeatType extends BaseModel {
   // private int showSeatTypeId;
    @ManyToOne
    //@JoinColumn(name = "show_id")
    private Shows shows;
    @ManyToOne
   // @JoinColumn(name = "id")
    private SeatType seatType;
    private double price;

 public ShowSeatType(Shows show, SeatType seatType, double price) {
  super();
  this.shows=show;
  this.seatType =seatType;
  this.price =price;
 }

 public ShowSeatType() {

 }

    public ShowSeatType(SeatType seatTypeGold, double v) {
        super();
        this.seatType =seatType;
        this.price =price;
    }
}
