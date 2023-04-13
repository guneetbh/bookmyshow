package org.bms.user.service;

import org.bms.model.*;
import org.bms.user.dto.BookTicketRequestDto;
import org.bms.user.dto.BookTicketResponseDto;
import org.bms.user.dto.TheatreRequestDto;
import org.bms.user.dto.TheatreResponseDto;

import java.util.List;

public interface UserService {

    public List<Movie> fetchMovie(String city);


    TheatreResponseDto fetchMovieTheatres(TheatreRequestDto theatreRequestDto);

    User createUser(String name, String email, String mobile, UserType userType);
}
