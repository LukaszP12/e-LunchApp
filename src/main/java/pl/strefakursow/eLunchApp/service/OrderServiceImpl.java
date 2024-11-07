package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.OrderDTO;
import pl.strefakursow.eLunchApp.DTO.OrderStatusDTO;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;
import pl.strefakursow.eLunchApp.repo.DiscountCodeRepo;
import pl.strefakursow.eLunchApp.repo.MenuItemRepo;
import pl.strefakursow.eLunchApp.repo.OrderItemRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;

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


    public OrderServiceImpl(OrderRepo orderRepo,
                            UserRepo userRepo,
                            RestaurantRepo restaurantRepo,
                            DelivererRepo delivererRepo,
                            MenuItemRepo menuItemRepo,
                            DiscountCodeRepo discountCodeRepo,
                            OrderItemRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
        this.delivererRepo = delivererRepo;
        this.menuItemRepo = menuItemRepo;
        this.discountCodeRepo = discountCodeRepo;
        this.orderItemRepo = orderItemRepo;
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

    }

    @Override
    public Optional<OrderDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public void setIsPaid(OrderDTO orderDTO) {

    }

    @Override
    public void setIsGivenOut(OrderDTO orderDTO, OrderStatusDTO orderStatusDTO) {

    }

    @Override
    public void setIsDelivered(OrderDTO orderDTO, OrderStatusDTO orderStatusDTO) {

    }

    @Override
    public UserDTO newOperationForPaidOrder(OrderDTO orderDTO) {
        return null;
    }
}
