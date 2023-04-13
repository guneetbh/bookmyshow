package org.bms.user.service.impl;

import org.bms.model.City;
import org.bms.user.repositories.CityRepository;
import org.bms.user.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }
    @Override
    public City save(String city) {
        City cityForThearte = new City();
        cityForThearte.setCityName(city);
       City savedCity = cityRepository.save(cityForThearte);
        return savedCity;
    }
}
