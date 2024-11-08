package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.MenuItemDTO;
import pl.strefakursow.eLunchApp.repo.DishRepo;
import pl.strefakursow.eLunchApp.repo.MenuItemRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepo menuItemRepo;
    private final RestaurantRepo restaurantRepo;
    private final DishRepo dishRepo;

    public MenuItemServiceImpl(MenuItemRepo menuItemRepo, RestaurantRepo restaurantRepo, DishRepo dishRepo) {
        this.menuItemRepo = menuItemRepo;
        this.restaurantRepo = restaurantRepo;
        this.dishRepo = dishRepo;
    }

    @Override
    public List<MenuItemDTO> getAll() {
        return menuItemRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, MenuItemDTO menuItemDTO) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<MenuItemDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
