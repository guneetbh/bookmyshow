package org.bms.user.service.impl;

import org.bms.model.Movie;
import org.bms.model.User;
import org.bms.model.UserType;
import org.bms.user.dto.BookTicketResponseDto;
import org.bms.user.dto.TheatreRequestDto;
import org.bms.user.dto.TheatreResponseDto;
import org.bms.user.repositories.ShowsRepository;
import org.bms.user.repositories.UserRepository;
import org.bms.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<Movie> fetchMovie(String city) {
        return null;
    }

    @Override
    public TheatreResponseDto fetchMovieTheatres(TheatreRequestDto theatreRequestDto) {
        return null;
    }

    @Override
    public User createUser(String name, String email, String mobile, UserType userType) {
        User user = new User();
        user.setUserEmail(email);
        user.setUserName(name);
        user.setUserMobile(mobile);
        user.setUserType(userType);
        User savedUser = userRepository.save(user);
        return  savedUser;
    }
}
