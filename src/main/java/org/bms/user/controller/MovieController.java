package org.bms.user.controller;

import org.bms.exceptions.MovieAlreadyExist;
import org.bms.model.Actor;
import org.bms.model.Movie;
import org.bms.user.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieController {
    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    public Movie createMovie(String name, String language, String genre, List<Actor> cast) {
        Movie movie = null;
        try {
                 movie = movieService.createMovie(name, language, genre, cast);
                return movie;
            }catch(MovieAlreadyExist e){
                e.getMessage();
                //set the desired response in DTO and send
                return movie;
            }
    }
}
