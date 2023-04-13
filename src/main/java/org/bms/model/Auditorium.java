package org.bms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    //private int auditorium;
    private String audiName;
    @OneToMany(mappedBy = "auditorium")
    private List<Shows> shows;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Features> features;

    @OneToMany
    private List<Seats> seats;
}
