package org.bms.user.service.impl;

import jakarta.persistence.NonUniqueResultException;
import org.bms.model.*;
import org.bms.user.dto.MovieScreenResponseDto;
import org.bms.user.repositories.*;
import org.bms.user.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    private AuditoriumRepository auditoriumRepository;
    private SeatRepository seatRepository;

    private MovieRepository movieRepository;

    private ShowsRepository showsRepository;


    @Autowired
    public TheatreServiceImpl(TheatreRepository theatreRepository,
                              CityRepository cityRepository,
                              AuditoriumRepository auditoriumRepository,
                              SeatRepository seatRepository,
                              MovieRepository movieRepository,
                              ShowsRepository showsRepository){
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
        this.showsRepository = showsRepository;
    }
    @Override
    public Theatre createTheatre(String name, String address, String company, City city) {
        Theatre theatre = new Theatre();
        theatre.setTheatreName(name);
        theatre.setCompany(company);
        theatre.setAddress(address);
        Theatre savedTheatre = theatreRepository.save(theatre);

        List cityTheatres = new ArrayList();
        cityTheatres.add(savedTheatre);
        //map theatre to city
        City ci = cityRepository.findCityById(city.getId());
        ci.setTheatres(cityTheatres);
        cityRepository.save(ci);
        return savedTheatre;
    }



    @Override
    public Auditorium addAuditorium(String screen, Theatre theatre, List<Features> features, List<Seats> seats) {
        //List<Seats> savedSeats = seatRepository.saveAll(seats);
        List<Seats> allSeats = new ArrayList<>();
        for (Seats seat : seats){
            Seats st = seatRepository.save(seat);
            allSeats.add(st);
        }
System.out.println("Seats saved");
        Auditorium audi = new Auditorium();
        audi.setAudiName(screen);
        audi.setFeatures(features);
        audi.setSeats(allSeats);
        Auditorium auditorium = auditoriumRepository.save(audi);
        System.out.println("Auditorium saved");

        List<Auditorium> theatreAuditorium = new ArrayList();
        theatreAuditorium.add(auditorium);
        Theatre theatre1 = theatreRepository.findTheatreById(theatre.getId());
        theatre1.setAuditorium(theatreAuditorium);
        theatreRepository.save(theatre1);
        return auditorium;
    }

    @Override
    public MovieScreenResponseDto fetchTheatres(String city, String movie) throws NonUniqueResultException {
        //findShowbyMovie
       // List<Theatre> theatres = new ArrayList<>();
        List<Theatre> movieTheatres = new ArrayList<>();
        MovieScreenResponseDto responseDto = new MovieScreenResponseDto();
        Movie _movie = movieRepository.findByMovieNameEquals(movie);
        //find Auditorium for the shows
        City movieCity = cityRepository.findByCityNameEquals(city);
        List<Theatre> theatres  = movieCity.getTheatres();

        List<Shows> movieShows = showsRepository.findByMovie(_movie);
       // City cityTheatres = cityRepository.findAllByCity(movieCity);
      //  List<Theatre> theatres=  cityTheatres.getTheatres();
        for (Shows show: movieShows){
         Theatre theatre =  theatreRepository.findAllByAuditorium(show.getAuditorium());

            for (Theatre theatre1 : theatres){
                if(theatre1.getId() == theatre.getId()){
                    movieTheatres.add(theatre);
                }
            }
        }
        responseDto.setTheatres(movieTheatres);
        responseDto.setShows(movieShows);
        //find all theatres for the audi in given city
        return responseDto;
    }
}
