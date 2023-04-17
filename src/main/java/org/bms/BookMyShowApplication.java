
package org.bms;

import org.bms.model.*;
import org.bms.user.controller.*;
import org.bms.user.dto.BookTicketRequestDto;
import org.bms.user.dto.BookTicketResponseDto;
import org.bms.user.dto.MovieScreenRequestDto;
import org.bms.user.dto.MovieScreenResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    private BookingController bookingController;
    private CityController cityController;
    private TheatreController theatreController;
    private MovieController movieController;

    private SeatTypeController seatTypeController;

    private ShowController showController;

    private UserController userController;


    @Autowired
    public BookMyShowApplication(BookingController bookingController,
                                 CityController cityController,
                                 TheatreController theatreController,
                                 MovieController movieController,
                                 SeatTypeController seatTypeController,
                                 ShowController showController,
                                 UserController userController) {
        this.bookingController = bookingController;
        this.cityController = cityController;
        this.theatreController = theatreController;
        this.movieController = movieController;
        this.seatTypeController = seatTypeController;
        this.showController = showController;
        this.userController = userController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

        //Create/Register user
        User user = userController.createUser("Guneet", "guneet.bh@gmail.com", "9582083815", UserType.USER);

        // Controller to create  movie
        List<Actor> cast = new ArrayList();
        Actor actor1 = new Actor(1, "Jan");
        cast.add(actor1);
        Actor actor2 = new Actor(2, "Joe");
        cast.add(actor2);

        Movie movie = movieController.createMovie("Avatar", "english", "art", cast);

        // create city
        City city = cityController.addCity("New Delhi");
        City cityG = cityController.addCity("Gurugram");
        City cityB = cityController.addCity("Bangalore");

        //create theatre
        Theatre theatre = theatreController.createTheatre("2B Lane", "INOX", "Regal", city);
        Theatre theatre1 = theatreController.createTheatre("Payal", "PVR", "PVR Naraina", city);
        Theatre theatre2 = theatreController.createTheatre("Mall Road", "PVR", "Gurugram 1", cityG);


        //create 3 seats types -vip, gold, platinum
//
        SeatType seatType = new SeatType("VIP");
        SeatType seatTypeGold = new SeatType("GOLD");
        SeatType seatTypePlat = new SeatType("PLATINUM");
        List<SeatType> seatTypes = new ArrayList<>();
        seatTypes.add(seatType);
        seatTypes.add(seatTypeGold);
        seatTypes.add(seatTypePlat);
        List<SeatType> savedSeats = seatTypeController.createSeatTypes(seatTypes);
        System.out.println("Seat types added");
        // create seats in auditorium
        Seats seats1 = new Seats(1, "2L", 1, savedSeats.stream().filter
                (c -> c.getSeatTypeName().equals(seatType.getSeatTypeName())).findAny().get());
        Seats seats2 = new Seats(2, "2M", 1, savedSeats.stream().filter
                (c -> c.getSeatTypeName().equals(seatTypeGold.getSeatTypeName())).findAny().get());
        Seats seatG_1 = new Seats(5, "5P", 5, savedSeats.stream().filter
                (c -> c.getSeatTypeName().equals(seatTypePlat.getSeatTypeName())).findAny().get());
        Seats seatP_1 = new Seats(5, "6A", 6, savedSeats.stream().filter
                (c -> c.getSeatTypeName().equals(seatTypePlat.getSeatTypeName())).findAny().get());
        Seats seats3 = new Seats(1, "58L", 1, savedSeats.stream().filter
                (c -> c.getSeatTypeName().equals(seatType.getSeatTypeName())).findAny().get());
        Seats seats4 = new Seats(1, "59L", 1, savedSeats.stream().filter
                (c -> c.getSeatTypeName().equals(seatType.getSeatTypeName())).findAny().get());
        Seats seats5 = new Seats(1, "60L", 1, savedSeats.stream().filter
                (c -> c.getSeatTypeName().equals(seatTypeGold.getSeatTypeName())).findAny().get());
        Seats seats6 = new Seats(1, "61L", 1, savedSeats.stream().filter
                (c -> c.getSeatTypeName().equals(seatTypePlat.getSeatTypeName())).findAny().get());
        Seats seats7 = new Seats(1, "62L", 1, savedSeats.stream().filter
                (c -> c.getSeatTypeName().equals(seatTypePlat.getSeatTypeName())).findAny().get());
        List<Seats> audiSeats = new ArrayList<>();
        audiSeats.add(seats1);
        audiSeats.add(seats2);
        audiSeats.add(seatG_1);
        audiSeats.add(seatP_1);
        audiSeats.add(seats3);
        audiSeats.add(seats4);
        audiSeats.add(seats5);
        audiSeats.add(seats6);
        audiSeats.add(seats7);
        // Seats seatsCreated = theatreController.addSeats(audiSeats);
        List<Features> features = new ArrayList<>();
        features.add(Features.DOLBY);
        features.add(Features.THREE_D);
        List<Features> features2 = new ArrayList<>();
        features2.add(Features.TWO_D);
        // add auditorium
        Auditorium audi1 = theatreController.addAuditorium("Screen 1", theatre1, features, audiSeats);
        //Auditorium audi2 =  theatreController.addAuditorium("Screen 1" , theatre1, features, audiSeats);
        //theatreController.addAuditorium("Screen 1" , theatre1, features2, audiSeats);


        // create a show
        Shows show = new Shows(Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), audi1, movie, features);
       // Shows show1 = new Shows(Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), audi1, movie, features);

        //Set show seat types
       Map<SeatType, Double> showSeatTypes = new HashMap<SeatType, Double>();
        showSeatTypes.put(seatTypeGold, 550.00);
        showSeatTypes.put(seatTypePlat, 800.00);
        showSeatTypes.put(seatType, 400.00);
        Shows savedShow = showController.createShow(show, showSeatTypes);


        //showSeat
        ShowSeat showSeat = new ShowSeat(ShowSeatStatus.AVAILABLE, seats1, savedShow);
        //ShowSeat ss_1 = showController.saveShowSeat(showSeat);
        ShowSeat showSeat1 = new ShowSeat(ShowSeatStatus.AVAILABLE, seats2, savedShow);
        //ShowSeat ss_2 = showController.saveShowSeat(showSeat1);
        ShowSeat ss_3 = new ShowSeat(ShowSeatStatus.AVAILABLE, seats3, savedShow);
        ShowSeat ss_4 = new ShowSeat(ShowSeatStatus.AVAILABLE, seats4, savedShow);
        ShowSeat ss_5= new ShowSeat(ShowSeatStatus.AVAILABLE, seats5, savedShow);
        ShowSeat ss_6 = new ShowSeat(ShowSeatStatus.AVAILABLE, seats6, savedShow);
        ShowSeat ss_7 = new ShowSeat(ShowSeatStatus.AVAILABLE, seats7, savedShow);
        List<ShowSeat> saveShowSeats = new ArrayList<>();
        saveShowSeats.add(showSeat);
        saveShowSeats.add(showSeat1);
        saveShowSeats.add(ss_3);
        saveShowSeats.add(ss_4);
        saveShowSeats.add(ss_5);
        saveShowSeats.add(ss_6);
        saveShowSeats.add(ss_7);
        List<ShowSeat> shSeats = showController.saveShowSeat(saveShowSeats);
        List<Long> showSeats = new ArrayList<>();
        int i =0;
        for (ShowSeat sh: shSeats) {
            showSeats.add(sh.getId());
           if(i==1) break;
           i++;
        }
        System.out.println("#######Browse theatres currently running the movie in the given town#######");
        MovieScreenRequestDto movieScreenRequestDto = new MovieScreenRequestDto();
        movieScreenRequestDto.setCity("New Delhi");
        movieScreenRequestDto.setMovie("Avatar");

        MovieScreenResponseDto movieScreenResponseDto = theatreController.fetchTheatres(movieScreenRequestDto);
       if( movieScreenResponseDto.getStatus().equals("Success")){
          List<Theatre> theatres =  movieScreenResponseDto.getTheatres();
          for(Theatre theatre3: theatres){
              System.out.println(movieScreenRequestDto.getCity() +"- "+theatre3.getTheatreName() + ",  " + theatre3.getCompany());

//              for(Auditorium audi : theatre3.getAuditorium()){
//                  System.out.println("Auditorium Name: "+audi.getAudiName() );
//              }
          }
          List<Shows> movieShows =  movieScreenResponseDto.getShows();
          for (Shows shows: movieShows){
              System.out.println("Show Name: "+shows.getMovie().getMovieName() +"\n"+
                      "ShowStart Time:"+ shows.getStartTime() +"\n"+
                      "Show End Time:" +shows.getEndTime() );
          }
        }
        System.out.println("#######Browse theatres currently running the movie in the given town#######");
        System.out.println("#######");
        System.out.println("#######");
        System.out.println("#######Ready to book ticket#######");

        //Book ticket
        BookTicketRequestDto requestDto = new BookTicketRequestDto();
        requestDto.setUserId(user.getId());
        requestDto.setShowId(savedShow.getId());
        requestDto.setShowSeatIds(showSeats);
        BookTicketResponseDto responseDto = bookingController.bookTicket(requestDto);
        //////////////////////
        System.out.println("*****Ticket status******\n" +
                responseDto.getStatus());
        System.out.println("********Booking Info********\n"
                + "Booked by: " + responseDto.getBooking().getBookedBy().getUserName() + "\n"
                + "Booked on:" + responseDto.getBooking().getBookingTime() + "\n"
                + "Booking Amount: " + responseDto.getBooking().getAmount() + "\n"
                + "Theatre: " + responseDto.getBooking().getShows().getAuditorium().getAudiName() + "\n"
                + "Show: " + responseDto.getBooking().getShows().getMovie().getMovieName() + "\n"
                + "Seats: " );
                responseDto.getBooking().getShowSeats().stream().forEach(seat -> System.out.println(seat.getSeats().getSeatName()));
        System.out.println("********Booking Info********");

        //#############Scenerio 3 ################################//
        //Same seats shall not be booked by two user for the same movie show//

        Map<String, Long> showSeatIds = new HashMap<>();
        for(ShowSeat showseat: shSeats){
            showSeatIds.put(showseat.getSeats().getSeatName(), showseat.getId());
     }
        TicketBookRunner ticketBookRunner1 = new TicketBookRunner(
                this.bookingController,
                1L,
                List.of(showSeatIds.get("58L"), showSeatIds.get("59L"), showSeatIds.get("60L")),
                1L
        );

        TicketBookRunner ticketBookRunner2 = new TicketBookRunner(
                this.bookingController,
                1L,
                List.of(showSeatIds.get("60L"), showSeatIds.get("61L"), showSeatIds.get("62L")),
                1L
        );

        Thread t1 = new Thread(ticketBookRunner1);
        Thread t2 = new Thread(ticketBookRunner2);
        t1.start();
        t2.start();
    }
}