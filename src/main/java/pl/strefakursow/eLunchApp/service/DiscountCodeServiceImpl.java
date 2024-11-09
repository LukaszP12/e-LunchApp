package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.DiscountCodeDTO;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.model.DiscountCode;
import pl.strefakursow.eLunchApp.model.User;
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
            for (UserDTO userDTO : discountCodeDTO.getUsers()) {
                userRepo.findByUUID(userDTO.getUuid())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
            }
        }

        DiscountCode discountCode = discountCodeRepo.findByUUID(discountCodeDTO.getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));


    }

    @Override
    public void delete(UUID uuid) {
        DiscountCode discountCode = discountCodeRepo.findByUUID(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        discountCodeRepo.deleteById(discountCode.getId());
    }

//    @Override
//    public Optional<DiscountCodeDTO> getByUuid(UUID uuid) {
//        return deliveryAddressRepo.findByUUID(uuid).map(ConverterUtils::convert);
//    }

    @Override
    public Optional<DiscountCodeDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
