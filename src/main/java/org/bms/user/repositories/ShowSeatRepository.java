package org.bms.user.repositories;

import jakarta.persistence.LockModeType;
import org.bms.model.ShowSeat;
import org.bms.model.ShowSeatType;
import org.bms.model.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllByIdIn(List<Long> id);

    ShowSeat save(ShowSeat showSeat);

    //List<ShowSeat> saveAll(List<ShowSeat> entities);
}
