package pl.strefakursow.eLunchApp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embeddable;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.eLunchApp.validator.PeriodTimeConstraint;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

@GeneratePojoBuilder
@PeriodTimeConstraint
@Embeddable
public class PeriodTimeDTO {

    public static class View {
        public interface Basic {
        }
    }

    @JsonView(View.Basic.class)
    @Nullable
    private LocalDateTime begin;

    @JsonView(View.Basic.class)
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
