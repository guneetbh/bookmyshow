package org.bms.user.service;

import org.bms.model.SeatType;

import java.util.List;

public interface SeatTypeService {
    List<SeatType> createSeatTypes(List<SeatType> seatTypes);
}
