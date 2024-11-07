package pl.strefakursow.eLunchApp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class DishDTO {

    public static class View {
        public interface Basic {
        }

        public interface Extended extends DeliveryAddressDTO.View.Basic {
        }
    }
    public interface DataUpdateValidation {}

    private Long id;

    @JsonView(DiscountCodeDTO.View.Basic.class)
    @NotNull
    private UUID uuid;

    @JsonView(DiscountCodeDTO.View.Extended.class)
    @NotNull
    @Min(1)
    private Integer quantity;

    @JsonView(DiscountCodeDTO.View.Extended.class)
    @NotNull
    private ProductDTO productDTO;

    @JsonView(DiscountCodeDTO.View.Extended.class)
    @Nullable
    @Null(groups = DataUpdateValidation.class)
    private List<MenuItemDTO> menuItemDTOS;

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

    public ProductDTO getProduct() {
        return productDTO;
    }

    public void setProduct(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    @Nullable
    public List<MenuItemDTO> getMenuItems() {
        return menuItemDTOS;
    }

    public void setMenuItems(@Nullable List<MenuItemDTO> menuItemDTOS) {
        this.menuItemDTOS = menuItemDTOS;
    }
}
