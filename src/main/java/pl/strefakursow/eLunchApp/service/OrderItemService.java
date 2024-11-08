package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.model.DiscountCode;
import pl.strefakursow.eLunchApp.model.OrderItem;
import pl.strefakursow.eLunchApp.model.PriceType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemService {
    List<OrderItem> getAll();
    void addOrderItem(OrderItem orderItem);
    void delete(UUID uuid);
    Optional<OrderItem> getByUuid(UUID uuid);

    BigDecimal calculatePrice(List<OrderItem> orderItemList, BigDecimal startPrice, PriceType priceType) throws UnsupportedDataTypeException;

    BigDecimal applyDiscount(DiscountCode discountCode, BigDecimal orderBruttoPrice) throws UnsupportedDataTypeException;

}
