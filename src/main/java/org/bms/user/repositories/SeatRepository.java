package org.bms.user.repositories;

import org.bms.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository  extends JpaRepository<Seats, Long> {
    Seats save(Seats seats);
}

