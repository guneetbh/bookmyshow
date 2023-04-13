package org.bms.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.bms.model.Shows;
import org.bms.model.Theatre;

import java.util.List;

@Setter
@Getter
public class MovieScreenResponseDto {
    List<Theatre> theatres;
    List<Shows> shows;
    String status;
}
