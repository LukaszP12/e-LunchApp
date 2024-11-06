package pl.strefakursow.eLunchApp.model;

import jakarta.persistence.Embeddable;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Embeddable
public class Period {

    @Nullable
    private LocalTime begin;

    @Nullable
    private LocalTime end;

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
