package org.bms.user.repositories;

import org.bms.model.ShowSeatType;
import org.bms.model.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShowsEquals(Shows show);
}
