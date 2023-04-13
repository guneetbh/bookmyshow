package org.bms.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class SeatType extends BaseModel{
   // private int seatType;
    private String seatTypeName;

    public SeatType() {

    }

}
