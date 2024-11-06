package pl.strefakursow.eLunchApp.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.apache.catalina.User;
import pl.strefakursow.eLunchApp.model.enums.DiscountUnit;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class DiscountCodeDTO {

    private Long id;

    @NotNull
    private UUID uuid;

    @NotBlank
    private String code;

    @Column(scale = 2, precision = 12)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal discount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DiscountUnit discountUnit;

    @Nullable
    private List<User> users;

    @Nullable
    private List<RestaurantDTO> restaurantDTOS;

}
