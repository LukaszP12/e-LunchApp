package pl.strefakursow.eLunchApp.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pl.strefakursow.eLunchApp.model.enums.VatTax;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class MenuItemDTO {

    private Long id;

    @NotNull
    private UUID uuid;

    @NotBlank
    private String name;

    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal nettoPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private VatTax vatTax;

    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal bruttoPrice;

    @NotNull
    @Size(min = 1)
    private List<DishDTO> dishDTOS;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(BigDecimal nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public VatTax getVatTax() {
        return vatTax;
    }

    public void setVatTax(VatTax vatTax) {
        this.vatTax = vatTax;
    }

    public BigDecimal getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(BigDecimal bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }

    public List<DishDTO> getDishes() {
        return dishDTOS;
    }

    public void setDishes(List<DishDTO> dishDTOS) {
        this.dishDTOS = dishDTOS;
    }

}
