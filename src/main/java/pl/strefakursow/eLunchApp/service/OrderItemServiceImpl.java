package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
        return orderItemRepo.findAll();
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        
    }

    @Override
    public void delete(UUID uuid) {
        OrderItem orderItem = orderItemRepo.findByUUID(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderItemRepo.deleteById(orderItem.getId());
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
