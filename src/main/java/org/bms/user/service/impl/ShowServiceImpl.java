package org.bms.user.service.impl;

import org.bms.model.SeatType;
import org.bms.model.ShowSeat;
import org.bms.model.ShowSeatType;
import org.bms.model.Shows;
import org.bms.user.repositories.ShowSeatRepository;
import org.bms.user.repositories.ShowSeatTypeRepository;
import org.bms.user.repositories.ShowsRepository;
import org.bms.user.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShowServiceImpl implements ShowService {

    private ShowsRepository showsRepository;
    private ShowSeatRepository showSeatRepository;

    private ShowSeatTypeRepository showSeatTypeRepository;

    public ShowServiceImpl(ShowsRepository showsRepository,
                           ShowSeatRepository showSeatRepository,
                           ShowSeatTypeRepository showSeatTypeRepository) {
        this.showsRepository = showsRepository;
        this.showSeatRepository = showSeatRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    @Override
    public Shows save(Shows show,  Map<SeatType, Double> seatTypes) {
        Shows savedShow = showsRepository.save(show);
        for (Map.Entry<SeatType,Double> entry : seatTypes.entrySet()) {
            ShowSeatType shSeatType = new ShowSeatType();
            shSeatType.setShows(savedShow);
            shSeatType.setSeatType(entry.getKey());
            shSeatType.setPrice(entry.getValue());
            showSeatTypeRepository.save(shSeatType);
        }
        return savedShow;
    }

    @Override
    public ShowSeat saveShowSeat(ShowSeat showSeat) {
        ShowSeat savedShowSeat = showSeatRepository.save(showSeat);
        return savedShowSeat;
    }

    @Override
    public ShowSeatType saveShowSeatType(ShowSeatType showSeatType) {
        ShowSeatType savedShowSeatType = showSeatTypeRepository.save(showSeatType);
        return savedShowSeatType;
    }
}
