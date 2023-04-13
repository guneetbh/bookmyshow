package org.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import org.bms.model.Theatre;

import java.util.List;

@Getter
@Setter
@Entity
public class City  extends BaseModel{
    //private String cityId;
    private String cityName;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Theatre> theatres;
}
