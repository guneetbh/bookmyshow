package org.bms.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User extends BaseModel{
   // private int userId;
    private String userName;
    private String userMobile;
    private String userEmail;
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;
}
