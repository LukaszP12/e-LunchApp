package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.model.DiscountCode;
import pl.strefakursow.eLunchApp.model.OrderItem;
import pl.strefakursow.eLunchApp.model.PriceType;
import pl.strefakursow.eLunchApp.repo.OrderItemRepo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepo orderItemRepo;

    public OrderItemServiceImpl(OrderItemRepo orderItemRepo) {
        this.orderItemRepo = orderItemRepo;
    }

    @Override
    public List<OrderItem> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, OrderItem orderItem) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<OrderItem> getByUuid(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public BigDecimal calculatePrice(List<OrderItem> orderItemList, BigDecimal startPrice, PriceType priceType) throws UnsupportedDataTypeException {
        return null;
    }

    @Override
    public BigDecimal applyDiscount(DiscountCode discountCode, BigDecimal orderBruttoPrice) throws UnsupportedDataTypeException {
        return null;
    }
}
