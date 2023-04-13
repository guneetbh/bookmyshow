package org.bms.user.controller;

import org.bms.model.City;
import org.bms.user.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {
    private CityService cityService;

    @Autowired
     public CityController(CityService cityService){
         this.cityService = cityService;
     }

    public City addCity(String city) {
        //save city in DB
        City ci = cityService.save(city);
        return ci;
    }
}
