package org.bms.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class MovieScreenRequestDto {

    private String movie;
    private String city;
    private Date date;
}
