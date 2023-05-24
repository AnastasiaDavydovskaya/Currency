package by.fin.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RateResponseAbbreviationDto {

    private LocalDate calendarDate;
    private Float officialRate;
}
