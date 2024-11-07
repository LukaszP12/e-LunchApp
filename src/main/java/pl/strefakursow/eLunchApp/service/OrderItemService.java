package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.DTO.OrderItemDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemService {
    List<OrderItemDTO> getAll();

    void put(UUID uuid, OrderItemDTO orderItemDTO);

    void delete(UUID uuid);

    Optional<OrderItemDTO> getByUuid(UUID uuid);
}
