package org.bms.user.repositories;

import org.bms.model.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatTypeRepository  extends JpaRepository<SeatType, Long> {

    SeatType save(SeatType seatType);
}
