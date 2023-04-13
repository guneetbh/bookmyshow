package org.bms.partner.controller;

import org.bms.partner.dto.RegisterTheatreRequestDto;
import org.bms.partner.dto.RegisterTheatreResponseDto;
import org.bms.partner.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;

public class PartnerController {

    @Autowired
    PartnerService partnerService;
    //Register theatre
    public RegisterTheatreResponseDto register(RegisterTheatreRequestDto registerTheatreRequestDto){
       return partnerService.register(registerTheatreRequestDto);
    }

    //create shows, update and delete shows
}
