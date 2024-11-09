package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.OrderDTO;
import pl.strefakursow.eLunchApp.DTO.OrderStatusDTO;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.model.Order;
import pl.strefakursow.eLunchApp.model.User;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;
import pl.strefakursow.eLunchApp.repo.DeliveryAddressRepo;
import pl.strefakursow.eLunchApp.repo.DiscountCodeRepo;
import pl.strefakursow.eLunchApp.repo.MenuItemRepo;
import pl.strefakursow.eLunchApp.repo.OrderItemRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final RestaurantRepo restaurantRepo;
    private final DelivererRepo delivererRepo;
    private final MenuItemRepo menuItemRepo;
    private final DiscountCodeRepo discountCodeRepo;
    private final OrderItemRepo orderItemRepo;
    private final DeliveryAddressRepo deliveryAddressRepo;


    public OrderServiceImpl(OrderRepo orderRepo,
                            UserRepo userRepo,
                            RestaurantRepo restaurantRepo,
                            DelivererRepo delivererRepo,
                            MenuItemRepo menuItemRepo,
                            DiscountCodeRepo discountCodeRepo,
                            OrderItemRepo orderItemRepo,
                            DeliveryAddressRepo deliveryAddressRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
        this.delivererRepo = delivererRepo;
        this.menuItemRepo = menuItemRepo;
        this.discountCodeRepo = discountCodeRepo;
        this.orderItemRepo = orderItemRepo;
        this.deliveryAddressRepo = deliveryAddressRepo;
    }

    @Override
    public List<OrderDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, OrderDTO orderDTO) {

    }

    @Override
    public void delete(UUID uuid) {
        Order order = orderRepo.findByUUID(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        orderRepo.deleteById(order.getId());
    }

//    @Override
//    public Optional<OrderDTO> getByUuid(UUID uuid) {
//        return deliveryAddressRepo
//                .findByUUID(uuid)
//                .map(ConverterUtils::convert);
//    }


    @Override
    public Optional<OrderDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public void setIsPaid(OrderDTO orderDTO) {
        Order order = orderRepo.findByUUID(orderDTO.getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!order.getOrderStatus().getIsPaid()) {
            order.getOrderStatus().setIsPaid(true);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void setIsGivenOut(UUID uuid, OrderStatusDTO orderStatusDTO) {
        Order order = orderRepo.findByUUID(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!order.getOrderStatus().getIsPaid() || orderStatusDTO.getDeliveryTime() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        order.getOrderStatus().setGiveOutTime(orderStatusDTO.getGiveOutTime());
    }

    @Override
    public void setIsDelivered(UUID uuid, OrderStatusDTO orderStatusDTO) {
        Order order = orderRepo.findByUUID(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!order.getOrderStatus().getIsPaid() || order.getOrderStatus().getGiveOutTime() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        order.getOrderStatus().setDeliveryTime(orderStatusDTO.getDeliveryTime());
    }

    @Override
    public UserDTO newOperationForPaidOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public List<OrderDTO> getByUser(UserDTO userDTO) {
        User user = userRepo.findByUUID(userDTO.getUuid()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

//        return user.getOrders();
        return null;
    }
}
