package by.fin.web.repository;

import by.fin.web.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    List<Rate> findByAbbreviation(String abbreviation);
    Rate findByAbbreviationAndCalendarDate(String abbreviation, LocalDate calendarDate);
}
