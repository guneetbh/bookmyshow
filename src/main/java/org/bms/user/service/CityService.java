package org.bms.user.service;

import org.bms.model.City;
import org.springframework.stereotype.Service;


public interface CityService {
    City save(String city);
}
