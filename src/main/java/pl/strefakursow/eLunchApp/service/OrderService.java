package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.DTO.OrderDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<OrderDTO> getAll();

    void put(UUID uuid, OrderDTO orderDTO);

    void delete(UUID uuid);

    Optional<OrderDTO> getByUuid(UUID uuid);
}
