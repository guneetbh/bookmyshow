package org.bms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Shows extends BaseModel{

//S:A
    @ManyToOne
    private Auditorium auditorium;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Movie movie;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Features> features;

    public Shows( Date startTime, Date endTime, Auditorium auditorium,
                 Movie movie, List<Features>  features) {
        super();
        this.endTime = endTime;
        this.startTime = startTime;
        this.movie = movie;
        this.auditorium = auditorium;
        this.features = features;
    }

    public Shows() {

    }
}
