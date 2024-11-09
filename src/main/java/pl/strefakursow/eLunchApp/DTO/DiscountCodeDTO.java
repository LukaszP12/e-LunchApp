package pl.strefakursow.eLunchApp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.apache.catalina.User;
import pl.strefakursow.eLunchApp.model.Restaurant;
import pl.strefakursow.eLunchApp.model.enums.DiscountUnit;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class DiscountCodeDTO {

    public static class View {
        public interface Basic {}

        public interface Extended extends DeliveryAddressDTO.View.Basic {}
    }

    private Long id;

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Basic.class)
    @NotBlank
    private String code;

    @JsonView(View.Extended.class)
    @Column(scale = 2, precision = 12)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal discount;

    @JsonView(View.Extended.class)
    @NotNull
    @Enumerated(EnumType.STRING)
    private DiscountUnit discountUnit;

    @JsonView(View.Extended.class)
    @Nullable
    private List<User> users;

    @JsonView(View.Extended.class)
    @Nullable
    private List<UserDTO> usersDTOS;

    @JsonView(View.Extended.class)
    @Nullable
    private List<Restaurant> restaurants;

    @JsonView(View.Extended.class)
    @Nullable
    private List<RestaurantDTO> restaurantDTOS;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public DiscountUnit getDiscountUnit() {
        return discountUnit;
    }

    public void setDiscountUnit(DiscountUnit discountUnit) {
        this.discountUnit = discountUnit;
    }

    @Nullable
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(@Nullable List<User> users) {
        this.users = users;
    }

    @Nullable
    public List<UserDTO> getUsersDTOS() {
        return usersDTOS;
    }

    public void setUsersDTOS(@Nullable List<UserDTO> usersDTOS) {
        this.usersDTOS = usersDTOS;
    }

    @Nullable
    public List<RestaurantDTO> getRestaurantDTOS() {
        return restaurantDTOS;
    }

    public void setRestaurantDTOS(@Nullable List<RestaurantDTO> restaurantDTOS) {
        this.restaurantDTOS = restaurantDTOS;
    }

    @Nullable
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
