package org.bms.user.service;

import org.bms.model.*;
import org.bms.user.dto.MovieScreenResponseDto;

import java.util.List;

public interface TheatreService {
     Theatre createTheatre(String name,
                                 String address,
                                 String company,
                                 City city );



    Auditorium addAuditorium(String screen, Theatre theatre, List<Features> features, List<Seats> seats);

    MovieScreenResponseDto fetchTheatres(String city, String movie);
}
