package pl.strefakursow.eLunchApp.DTO;

import jakarta.persistence.Embeddable;
import pl.strefakursow.eLunchApp.validator.PeriodTimeConstraint;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

@PeriodTimeConstraint
@Embeddable
public class PeriodTimeDTO {

    @Nullable
    private LocalDateTime begin;

    @Nullable
    private LocalDateTime end;


    @Nullable
    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(@Nullable LocalDateTime begin) {
        this.begin = begin;
    }

    @Nullable
    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(@Nullable LocalDateTime end) {
        this.end = end;
    }
}
