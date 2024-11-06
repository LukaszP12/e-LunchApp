package pl.strefakursow.eLunchApp.DTO;

import jakarta.persistence.Embeddable;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.eLunchApp.validator.PeriodConstraint;

import javax.annotation.Nullable;
import java.time.LocalTime;

@GeneratePojoBuilder
@PeriodConstraint
@Embeddable
public class PeriodDTO {

    @Nullable
    private LocalTime begin;

    @Nullable
    private LocalTime end;

    @Nullable
    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(@Nullable LocalTime begin) {
        this.begin = begin;
    }

    @Nullable
    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(@Nullable LocalTime end) {
        this.end = end;
    }
}