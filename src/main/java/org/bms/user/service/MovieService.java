package org.bms.user.service;

import org.bms.exceptions.MovieAlreadyExist;
import org.bms.model.Actor;
import org.bms.model.Movie;

import java.util.List;

public interface MovieService {
    Movie createMovie(String name, String language, String genre, List<Actor> cast) throws MovieAlreadyExist;
}
