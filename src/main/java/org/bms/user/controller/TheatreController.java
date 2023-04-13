package org.bms.user.controller;

import jakarta.persistence.NonUniqueResultException;
import org.bms.model.*;
import org.bms.user.dto.MovieScreenRequestDto;
import org.bms.user.dto.MovieScreenResponseDto;
import org.bms.user.service.TheatreService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TheatreController {

    TheatreService theatreService;

    private  TheatreController( TheatreService theatreService){
        this.theatreService = theatreService;
    }
    public Theatre createTheatre(String name, String address, String company, City city) {
        //save theatre in DB
        Theatre theatre = theatreService.createTheatre( name,  address,  company,  city);
        return theatre;
    }

    public Auditorium addAuditorium(String screen, Theatre theatre, List<Features> features, List<Seats> seats) {
        //add auditorium in DB
       Auditorium auditorium =  theatreService.addAuditorium(screen, theatre, features, seats);
       return auditorium;
    }

    public MovieScreenResponseDto fetchTheatres(MovieScreenRequestDto requestDto) {
       MovieScreenResponseDto responseDto = null;
        try {
             responseDto = theatreService.fetchTheatres(requestDto.getCity(), requestDto.getMovie());
            responseDto.setStatus("Success");
        }catch(NonUniqueResultException e){
            responseDto.setStatus("Error" + e.getMessage());
        }
        return  responseDto;
    }
}
