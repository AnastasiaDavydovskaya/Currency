package by.fin.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RateResponseDto {

    private LocalDate calendarDate;
    private String abbreviation;
    private String name;
    private Float officialRate;
}
