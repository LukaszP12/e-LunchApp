package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.RestaurantDTO;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;

    public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public List<RestaurantDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, RestaurantDTO restaurantDTO) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<RestaurantDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
