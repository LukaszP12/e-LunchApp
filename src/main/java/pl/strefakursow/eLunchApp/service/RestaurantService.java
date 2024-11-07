package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.DTO.RestaurantDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantService {
    List<RestaurantDTO> getAll();

    void put(UUID uuid, RestaurantDTO restaurantDTO);

    void delete(UUID uuid);

    Optional<RestaurantDTO> getByUuid(UUID uuid);
}
