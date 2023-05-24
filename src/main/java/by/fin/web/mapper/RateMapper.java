package by.fin.web.mapper;

import by.fin.web.dto.RateResponseAbbreviationDto;
import by.fin.web.dto.RateResponseDto;
import by.fin.web.entity.Rate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RateMapper {

    RateResponseDto toRateResponse(Rate rate);
    RateResponseAbbreviationDto toRateResponseAbbreviation(Rate rate);
}
