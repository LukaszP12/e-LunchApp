package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.OpenTimeDTO;
import pl.strefakursow.eLunchApp.repo.OpenTimeRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OpenTimeServiceImpl implements OpenTimeService {

    private final OpenTimeRepo openTimeRepo;
    private final RestaurantRepo restaurantRepo;

    public OpenTimeServiceImpl(OpenTimeRepo openTimeRepo, RestaurantRepo restaurantRepo) {
        this.openTimeRepo = openTimeRepo;
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public List<OpenTimeDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, OpenTimeDTO openTimeDTO) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<OpenTimeDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
