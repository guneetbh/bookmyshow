package org.bms.model;

//import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
public class Actor extends BaseModel{
    private String name;

    public Actor(long i, String name) {
        super();
        this.name = name;
    }

    public Actor() {

    }
}
