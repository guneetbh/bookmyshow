package org.bms.user.service.impl;

import org.bms.exceptions.MovieAlreadyExist;
import org.bms.model.Actor;
import org.bms.model.Movie;
import org.bms.user.repositories.ActorRepository;
import org.bms.user.repositories.MovieRepository;
import org.bms.user.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ActorRepository actorRepository){

        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }
    @Override
    public Movie createMovie(String name, String language, String genre, List<Actor> cast) throws MovieAlreadyExist {
        //save actors
       // for (Actor actor : cast){
        List<Actor> actors = null;
        try{
          actors =  actorRepository.saveAll(cast);
       }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Actors saved in DB");

        Movie exMovie = movieRepository.findByMovieNameEquals(name);
        Movie movied = null;
        if(exMovie == null ) {
            //save Movie
            Movie movie = new Movie();
            movie.setMovieName(name);
            movie.setActor(actors);
            movie.setLanguage(language);
            movie.setGenre(genre);
            movied = movieRepository.save(movie);
            System.out.println("Movie saved in DB");
            return movied;
        }else{
         //   throw new MovieAlreadyExist(exMovie.getMovieName() +" already exist..");
            return exMovie;
        }

    }
}
