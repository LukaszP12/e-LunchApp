package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.OpenTimeDTO;
import pl.strefakursow.eLunchApp.model.OpenTime;
import pl.strefakursow.eLunchApp.model.OpenTimeBuilder;
import pl.strefakursow.eLunchApp.model.Restaurant;
import pl.strefakursow.eLunchApp.repo.OpenTimeRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static pl.strefakursow.eLunchApp.utils.ConverterUtils.convert;

@Service
public class OpenTimeServiceImpl implements OpenTimeService {

    private final OpenTimeRepo openTimeRepo;
    private final RestaurantRepo restaurantRepo;

    public OpenTimeServiceImpl(OpenTimeRepo openTimeRepo, RestaurantRepo restaurantRepo) {
        this.openTimeRepo = openTimeRepo;
        this.restaurantRepo = restaurantRepo;
    }

//    @Override
//    public List<OpenTimeDTO> getAll() {
//        return openTimeRepo.findAll().stream()
//                .map(ConverterUtils::convert)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<OpenTimeDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, OpenTimeDTO openTimeDTO) {
        if (!Objects.equals(openTimeDTO.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Restaurant restaurant = restaurantRepo.findByUUID(openTimeDTO.getRestaurantDTO().getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        OpenTime openTime = openTimeRepo.findByUUID(openTimeDTO.getUuid())
                .orElseThrow(() -> newOpenTime(uuid, restaurant));

        if (!Objects.equals(openTime.getRestaurant().getUuid(), openTimeDTO.getRestaurantDTO().getUuid())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        openTime.setDayOfWeek(openTimeDTO.getDayOfWeek());
        openTime.setPeriodTime(convert(openTimeDTO.getPeriodTimeDTO()));

        if (openTime.getId() == null){
            openTimeRepo.save(openTime);
        }
    }

    @Override
    public void delete(UUID uuid) {
        OpenTime openTime = openTimeRepo.findByUUID(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        openTimeRepo.delete(openTime);
    }

    @Override
    public Optional<OpenTimeDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }

//    @Override
//    public Optional<OpenTimeDTO> getByUuid(UUID uuid) {
//        return openTimeRepo.findByUUID(uuid).map(ConverterUtils::convert);
//    }

    private OpenTime newOpenTime(UUID uuid, Restaurant restaurant) {
        return new OpenTimeBuilder()
                .withUuid(uuid)
                .withRestaurant(restaurant)
                .build();
    }
}
