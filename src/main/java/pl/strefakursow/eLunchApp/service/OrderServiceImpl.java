package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.OrderDTO;
import pl.strefakursow.eLunchApp.DTO.OrderItemDTO;
import pl.strefakursow.eLunchApp.DTO.OrderStatusDTO;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.model.Deliverer;
import pl.strefakursow.eLunchApp.model.MenuItem;
import pl.strefakursow.eLunchApp.model.Order;
import pl.strefakursow.eLunchApp.model.OrderBuilder;
import pl.strefakursow.eLunchApp.model.OrderItem;
import pl.strefakursow.eLunchApp.model.OrderStatus;
import pl.strefakursow.eLunchApp.model.OrderStatusBuilder;
import pl.strefakursow.eLunchApp.model.Restaurant;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        if (!Objects.equals(orderDTO.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        User user = userRepo.findByUUID(orderDTO.getUser().getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Deliverer deliverer = delivererRepo.findByUUID(orderDTO.getDeliverer().getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Restaurant restaurant = restaurantRepo.findByUUID(orderDTO.getRestaurant().getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Order order = orderRepo.findByUUID(orderDTO.getUuid())
                .orElseGet(() -> newOrder(uuid, user, restaurant));

        if (!Objects.equals(order.getUser().getUuid(), orderDTO.getUser().getUuid())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(restaurant.getUuid(), orderDTO.getRestaurant().getUuid())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (order.getOrderStatus().getDeliveryTime() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        putOrderItems(orderDTO);
        putDiscountCode(orderDTO);
    }

    private void putDiscountCode(OrderDTO orderDTO) {

    }

    private List<OrderItem> putOrderItems(OrderDTO orderDTO) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            MenuItem menuItem = menuItemRepo.findByUUID(orderItemDTO.getMenuItem().getUuid())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

            OrderItem orderItem = orderItemRepo.findByUUID(orderDTO.getUuid())
                    .orElseGet(() -> newOrderItem(orderDTO.getUuid()));
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setMenuItem(menuItem);
            if (orderItem.getId() == null) {
                orderItemRepo.save(orderItem);
            }
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private OrderItem newOrderItem(UUID uuid) {
        return null;
    }

    private Order newOrder(UUID uuid, User user, Restaurant restaurant) {
        return new OrderBuilder()
                .withUuid(uuid)
                .withRestaurant(restaurant)
                .withOrderStatus(newOrderStatus())
                .build();
    }

    private OrderStatus newOrderStatus() {
        return new OrderStatusBuilder()
                .withOrderTime(Instant.now())
                .withIsPaid(false)
                .build();
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
