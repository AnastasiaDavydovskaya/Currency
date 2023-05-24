package by.fin.web.entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@Entity
public class Rate extends AbstractEntity {

    @JsonSetter("Date")
    private LocalDate calendarDate;
    @JsonSetter("Cur_Abbreviation")
    private String abbreviation;
    @JsonSetter("Cur_Name")
    private String name;
    @JsonSetter("Cur_OfficialRate")
    private Float officialRate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rate rate = (Rate) o;
        return id != null && Objects.equals(id, rate.id);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
