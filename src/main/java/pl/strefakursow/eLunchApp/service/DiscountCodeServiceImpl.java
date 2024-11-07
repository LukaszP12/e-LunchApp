package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.DiscountCodeDTO;
import pl.strefakursow.eLunchApp.repo.DiscountCodeRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepo discountCodeRepo;
    private final UserRepo userRepo;
    private final RestaurantRepo restaurantRepo;

    public DiscountCodeServiceImpl(DiscountCodeRepo discountCodeRepo, UserRepo userRepo, RestaurantRepo restaurantRepo) {
        this.discountCodeRepo = discountCodeRepo;
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public List<DiscountCodeDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, DiscountCodeDTO discountCodeDTO) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<DiscountCodeDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}