package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.DiscountCodeDTO;
import pl.strefakursow.eLunchApp.DTO.DiscountCodeDTOBuilder;
import pl.strefakursow.eLunchApp.DTO.RestaurantDTO;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.model.DiscountCode;
import pl.strefakursow.eLunchApp.model.DiscountCodeBuilder;
import pl.strefakursow.eLunchApp.model.Restaurant;
import pl.strefakursow.eLunchApp.model.User;
import pl.strefakursow.eLunchApp.model.enums.DiscountUnit;
import pl.strefakursow.eLunchApp.repo.DeliveryAddressRepo;
import pl.strefakursow.eLunchApp.repo.DiscountCodeRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static pl.strefakursow.eLunchApp.utils.ConverterUtils.convert;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepo discountCodeRepo;
    private final UserRepo userRepo;
    private final RestaurantRepo restaurantRepo;
    private final DeliveryAddressRepo deliveryAddressRepo;

    public DiscountCodeServiceImpl(DiscountCodeRepo discountCodeRepo, UserRepo userRepo, RestaurantRepo restaurantRepo,
                                   DeliveryAddressRepo deliveryAddressRepo) {
        this.discountCodeRepo = discountCodeRepo;
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
        this.deliveryAddressRepo = deliveryAddressRepo;
    }

//    @Override
//    public List<DiscountCodeDTO> getAll() {
//        return discountCodeRepo.findAll().stream()
//                .map(ConverterUtils::convert)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<DiscountCodeDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, DiscountCodeDTO discountCodeDTO) {
        if (!Objects.equals(discountCodeDTO.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        List<User> users = new ArrayList<>();
        if (discountCodeDTO.getUsers() != null) {
            for (UserDTO userDTO : discountCodeDTO.getUsersDTOS()) {
                User user = userRepo.findByUUID(userDTO.getUuid())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
                users.add(user);
            }
        }

        List<Restaurant> restaurants = new ArrayList<>();
        if (discountCodeDTO.getRestaurantDTOS() != null) {
            for (RestaurantDTO restaurantDTO : discountCodeDTO.getRestaurantDTOS()) {
                Restaurant restaurant = restaurantRepo.findByUUID(restaurantDTO.getUuid())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
                restaurants.add(restaurant);
            }
        }

        DiscountCode discountCode = discountCodeRepo.findByUUID(discountCodeDTO.getUuid())
                .orElseThrow(() -> newDiscountCode(uuid))
        discountCode.setCode(discountCodeDTO.getCode());
        discountCode.setDiscount(discountCodeDTO.getDiscount());
        discountCode.setDiscountUnit(discountCodeDTO.getDiscountUnit());
        discountCode.setPeriod(convert(discountCodeDTO.getPeriod()));
        discountCode.setUsers(users);
        discountCode.setRestaurants(restaurants);

        if (discountCode.getId() == null) {
            discountCodeRepo.save(discountCode);
        }
    }

    private DiscountCode newDiscountCode(UUID uuid) {
        return new DiscountCodeBuilder()
                .withUuid(uuid)
                .build();
    }

    @Override
    public void delete(UUID uuid) {
        DiscountCode discountCode = discountCodeRepo.findByUUID(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        discountCodeRepo.deleteById(discountCode.getId());
    }

    @Override
    public Optional<DiscountCodeDTO> getByUuid(UUID uuid) {
        return deliveryAddressRepo.findByUUID(uuid).map(ConverterUtils::convert);
    }
}
