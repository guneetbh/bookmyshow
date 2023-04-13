package org.bms.user.repositories;

import org.bms.model.Auditorium;
import org.bms.model.City;
import org.bms.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    Theatre save(Theatre theatre);

     Theatre findTheatreById(long id);

     Theatre findAllByAuditorium(Auditorium auditorium);

}
