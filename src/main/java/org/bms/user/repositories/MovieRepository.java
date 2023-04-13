package org.bms.user.repositories;

import org.bms.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie save(Movie movie);

    Movie findByMovieNameEquals(String movieName);
}
