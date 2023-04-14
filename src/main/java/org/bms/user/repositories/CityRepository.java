package org.bms.user.repositories;

import org.bms.model.City;
import org.bms.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City save(City city);
    City findCityById(Long Id);
     City findFirstByCityNameEquals(String City);

   //  City findAllByCity(City city);

}
