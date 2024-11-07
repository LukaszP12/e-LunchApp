package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.DTO.OrderDTO;
import pl.strefakursow.eLunchApp.DTO.OrderStatusDTO;
import pl.strefakursow.eLunchApp.DTO.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<OrderDTO> getAll();

    void put(UUID uuid, OrderDTO orderDTO);

    void delete(UUID uuid);

    Optional<OrderDTO> getByUuid(UUID uuid);

    void setIsPaid(OrderDTO orderDTO);
    void setIsGivenOut(UUID uuid, OrderStatusDTO orderStatusDTO);
    void setIsDelivered(UUID uuid, OrderStatusDTO orderStatusDTO);

    UserDTO newOperationForPaidOrder(OrderDTO orderDTO);

    List<OrderDTO> getByUser(UserDTO userDTO);
}
