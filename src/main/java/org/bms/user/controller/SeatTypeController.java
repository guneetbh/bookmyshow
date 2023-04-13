package org.bms.user.controller;

import org.bms.model.SeatType;
import org.bms.user.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SeatTypeController {

    SeatTypeService seatTypeService;

    @Autowired
    public SeatTypeController(SeatTypeService seatTypeService){
        this.seatTypeService = seatTypeService;
    }
    public  List<SeatType> createSeatTypes(List<SeatType> seatTypes) {
        List<SeatType> savedSeats =  seatTypeService.createSeatTypes(seatTypes);
        return savedSeats;
    }
}
