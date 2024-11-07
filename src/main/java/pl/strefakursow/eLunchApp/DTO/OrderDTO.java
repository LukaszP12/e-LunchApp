package pl.strefakursow.eLunchApp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.eLunchApp.model.User;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class OrderDTO {

    public static class View {
        public interface Basic {
        }

        public interface Extended extends Basic {
        }
    }

    public interface OrderValidation {
    }

    public interface OrderStatusValidation {
    }

    private Long id;

    @JsonView(View.Extended.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Extended.class)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @Null(groups = OrderValidation.class)
    @NotNull
    private BigDecimal nettoPrice;

    @JsonView(View.Extended.class)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal bruttoPrice;

    @JsonView(View.Extended.class)
    @Nullable
    private DiscountCodeDTO discountCodeDTO;

    @JsonView(View.Extended.class)
    @Column(scale = 2, precision = 12)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal amountToPayBrutto;

    @JsonView(View.Extended.class)
    @Nullable
    private String note;

    @JsonView(View.Basic.class)
    @Null(groups = OrderValidation.class)
    @NotNull(groups = OrderStatusValidation.class)
    @Embedded
    private OrderStatusDTO orderStatusDTO;

    @JsonView(View.Extended.class)
    @NotNull
    private DeliveryAddressDTO deliveryAddressDTO;

    @JsonView(View.Extended.class)
    @NotNull
    @Size(min = 1)
    private List<OrderItemDTO> orderItemDTOS;

    @JsonView(View.Basic.class)
    @NotNull
    private User user;

    @JsonView(View.Basic.class)
    @NotNull
    private DelivererDTO delivererDTO;

    @JsonView(View.Basic.class)
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

    public BigDecimal getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(BigDecimal nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public BigDecimal getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(BigDecimal bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }

    @Nullable
    public DiscountCodeDTO getDiscountCode() {
        return discountCodeDTO;
    }

    public void setDiscountCode(@Nullable DiscountCodeDTO discountCodeDTO) {
        this.discountCodeDTO = discountCodeDTO;
    }

    public BigDecimal getAmountToPayBrutto() {
        return amountToPayBrutto;
    }

    public void setAmountToPayBrutto(BigDecimal amountToPayBrutto) {
        this.amountToPayBrutto = amountToPayBrutto;
    }

    @Nullable
    public String getNote() {
        return note;
    }

    public void setNote(@Nullable String note) {
        this.note = note;
    }

    public OrderStatusDTO getOrderStatus() {
        return orderStatusDTO;
    }

    public void setOrderStatus(OrderStatusDTO orderStatusDTO) {
        this.orderStatusDTO = orderStatusDTO;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItemDTOS;
    }

    public void setOrderItems(List<OrderItemDTO> orderItemDTOS) {
        this.orderItemDTOS = orderItemDTOS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DelivererDTO getDeliverer() {
        return delivererDTO;
    }

    public void setDeliverer(DelivererDTO delivererDTO) {
        this.delivererDTO = delivererDTO;
    }

    public RestaurantDTO getRestaurant() {
        return restaurantDTO;
    }

    public void setRestaurant(RestaurantDTO restaurantDTO) {
        this.restaurantDTO = restaurantDTO;
    }
}
