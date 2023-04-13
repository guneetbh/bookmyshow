package org.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Movie extends BaseModel{
    private String movieName;
    @ManyToMany
    private List<Actor> actor;

    private String language;
    private String genre;
}
