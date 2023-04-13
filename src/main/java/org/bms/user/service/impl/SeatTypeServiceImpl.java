package org.bms.user.service.impl;

import org.bms.model.SeatType;
import org.bms.user.repositories.SeatTypeRepository;
import org.bms.user.repositories.ShowSeatTypeRepository;
import org.bms.user.service.SeatTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {

    private SeatTypeRepository seatTypeRepository;

    public SeatTypeServiceImpl(SeatTypeRepository seatTypeRepository){
        this.seatTypeRepository = seatTypeRepository;
    }
    @Override
    public List<SeatType> createSeatTypes(List<SeatType> seatTypes) {
        List<SeatType> savedSatTypes = new ArrayList<>();
        for (SeatType seatType: seatTypes) {
            SeatType savedSeatType = seatTypeRepository.save(seatType);
            savedSatTypes.add(savedSeatType);
        }
        return savedSatTypes;
    }
}
