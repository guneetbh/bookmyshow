package org.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Theatre extends BaseModel{
    //private String theatreId;
    private String theatreName;
    private String address;
    @OneToMany
    private List<Auditorium> auditorium;
    private String company;
}
