package org.bms.partner.service;

import org.bms.partner.dto.RegisterTheatreRequestDto;
import org.bms.partner.dto.RegisterTheatreResponseDto;

public interface PartnerService {

    public RegisterTheatreResponseDto register(RegisterTheatreRequestDto registerTheatreRequestDto);
}
