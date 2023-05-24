package by.fin.web.service;


import by.fin.web.dto.RateRequestAbbreviationDto;
import by.fin.web.dto.RateRequestDto;
import by.fin.web.dto.RateResponseAbbreviationDto;
import by.fin.web.dto.RateResponseDto;

import java.util.List;

public interface RateService {

    List<RateResponseDto> findAllRate(RateRequestDto rateRequestDto);
    List<RateResponseAbbreviationDto> findAllRate(RateRequestAbbreviationDto rateRequestAbbreviationDto);
}
