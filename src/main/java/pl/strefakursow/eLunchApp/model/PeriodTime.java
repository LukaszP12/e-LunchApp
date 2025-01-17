package pl.strefakursow.eLunchApp.model;

import jakarta.persistence.Embeddable;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

@Embeddable
public class PeriodTime {

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
