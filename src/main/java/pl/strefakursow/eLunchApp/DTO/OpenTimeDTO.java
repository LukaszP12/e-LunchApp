package pl.strefakursow.eLunchApp.DTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.eLunchApp.model.enums.DayOfWeek;

import java.util.UUID;

@GeneratePojoBuilder
public class OpenTimeDTO {

    private Long id;

    @NotNull
    private UUID uuid;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @NotNull
    @Embedded
    private PeriodTimeDTO periodTimeDTO;

    @NotNull
    private RestaurantDTO restaurantDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public PeriodTimeDTO getPeriodTime() {
        return periodTimeDTO;
    }

    public void setPeriodTime(PeriodTimeDTO periodTimeDTO) {
        this.periodTimeDTO = periodTimeDTO;
    }

    public RestaurantDTO getRestaurant() {
        return restaurantDTO;
    }

    public void setRestaurant(RestaurantDTO restaurantDTO) {
        this.restaurantDTO = restaurantDTO;
    }
}
