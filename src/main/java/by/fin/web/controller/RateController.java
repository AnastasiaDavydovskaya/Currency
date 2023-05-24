package by.fin.web.controller;

import by.fin.web.dto.RateRequestAbbreviationDto;
import by.fin.web.dto.RateRequestDto;
import by.fin.web.dto.RateResponseAbbreviationDto;
import by.fin.web.dto.RateResponseDto;
import by.fin.web.service.impl.RateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/currencies")
@RestController
@RequiredArgsConstructor
public class RateController {

    private final RateServiceImpl rateService;

    @GetMapping
    public List<RateResponseDto> findAll(RateRequestDto rateRequestDto) {
        return rateService.findAllRate(rateRequestDto);
    }

    @GetMapping("/abbreviation")
    public List<RateResponseAbbreviationDto> findByAbbreviation(RateRequestAbbreviationDto rateRequestAbbreviationDto) {
        return rateService.findAllRate(rateRequestAbbreviationDto);
    }
}
