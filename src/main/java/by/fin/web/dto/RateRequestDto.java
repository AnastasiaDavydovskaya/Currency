package by.fin.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RateRequestDto {

    private String abbreviation;
    private String start;
    private String end;
}
