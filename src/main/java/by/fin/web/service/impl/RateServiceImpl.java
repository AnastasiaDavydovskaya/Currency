package by.fin.web.service.impl;

import by.fin.web.dto.RateRequestAbbreviationDto;
import by.fin.web.dto.RateRequestDto;
import by.fin.web.dto.RateResponseAbbreviationDto;
import by.fin.web.dto.RateResponseDto;
import by.fin.web.entity.Rate;
import by.fin.web.mapper.RateMapper;
import by.fin.web.repository.RateRepository;
import by.fin.web.service.RateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;
    private final RestTemplate restTemplate;
    private final RateMapper rateMapper;

    @Override
    public List<RateResponseDto> findAllRate(RateRequestDto rateRequestDto) {
        LocalDate start = LocalDate.parse(rateRequestDto.getStart());
        LocalDate end = LocalDate.parse(rateRequestDto.getEnd());

        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }

        List<Rate> listForUser = new ArrayList<>();
        List<Rate> listForDb = new ArrayList<>();
        for (LocalDate date : totalDates) {
            Rate rate = Objects.requireNonNull(
                    restTemplate.getForObject("https://api.nbrb.by/exrates/rates/" +
                            rateRequestDto.getAbbreviation() +
                            "?ondate=" + date + "&periodicity=0&parammode=2", Rate.class));
            if(rateRepository.findByAbbreviationAndCalendarDate(rateRequestDto.getAbbreviation(), date) == null) {
                listForDb.add(rate);
            }

            listForUser.add(rate);
        }

        rateRepository.saveAll(Objects.requireNonNull(listForDb));

        return listForUser.stream().map(rateMapper::toRateResponse).collect(Collectors.toList());
    }

    @Override
    public List<RateResponseAbbreviationDto> findAllRate(RateRequestAbbreviationDto rateRequestAbbreviationDto) {
        return rateRepository.findByAbbreviation(rateRequestAbbreviationDto.getAbbreviation())
                .stream()
                .map(rateMapper::toRateResponseAbbreviation).collect(Collectors.toList());
    }
}
