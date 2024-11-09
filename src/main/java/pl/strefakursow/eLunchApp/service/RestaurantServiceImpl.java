package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.RestaurantDTO;
import pl.strefakursow.eLunchApp.model.Restaurant;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;

    public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

//    @Override
//    public List<RestaurantDTO> getAll() {
//        return restaurantRepo.findAll().stream()
//                .map(ConverterUtils::convert)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<RestaurantDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, RestaurantDTO restaurantDTO) {

    }

    @Override
    public void delete(UUID uuid) {
        Restaurant restaurant = restaurantRepo.findByUUID(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        restaurantRepo.deleteById(restaurant.getId());
    }

//    @Override
//    public Optional<RestaurantDTO> getByUuid(UUID uuid) {
//        return restaurantRepo
//                .findByUUID(uuid)
//                .map(ConverterUtils::convert);
//    }

    @Override
    public Optional<RestaurantDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
