package org.bms.user.repositories;

import org.bms.model.Movie;
import org.bms.model.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowsRepository extends JpaRepository<Shows, Long >{
    Shows findByIdEquals(Long id);
    List<Shows> findByMovie(Movie movie);

}
