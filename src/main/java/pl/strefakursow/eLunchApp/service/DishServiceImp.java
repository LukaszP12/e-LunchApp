package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.DishDTO;
import pl.strefakursow.eLunchApp.repo.DishRepo;
import pl.strefakursow.eLunchApp.repo.MenuItemRepo;
import pl.strefakursow.eLunchApp.repo.ProductRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DishServiceImp implements DishService {

    private final DishRepo dishRepo;
    private final MenuItemRepo menuItemRepo;
    private final ProductRepo productRepo;

    public DishServiceImp(DishRepo dishRepo, MenuItemRepo menuItemRepo, ProductRepo productRepo) {
        this.dishRepo = dishRepo;
        this.menuItemRepo = menuItemRepo;
        this.productRepo = productRepo;
    }

//    @Override
//    public List<DishDTO> getAll() {
//        return DishRepo.findAll().stream()
//                .map(ConverterUtils::convert)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<DishDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, DishDTO dishDTO) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<DishDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
