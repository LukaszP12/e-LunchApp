package pl.strefakursow.eLunchApp.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class OrderItemDTO {

    private Long id;

    @NotNull
    private UUID uuid;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    private MenuItemDTO menuItemDTO;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MenuItemDTO getMenuItem() {
        return menuItemDTO;
    }

    public void setMenuItem(MenuItemDTO menuItemDTO) {
        this.menuItemDTO = menuItemDTO;
    }
}
