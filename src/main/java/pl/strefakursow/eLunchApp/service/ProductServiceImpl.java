package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.ProductDTO;
import pl.strefakursow.eLunchApp.repo.DishRepo;
import pl.strefakursow.eLunchApp.repo.IngredientRepo;
import pl.strefakursow.eLunchApp.repo.ProductRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final IngredientRepo ingredientRepo;
    private final DishRepo dishRepo;

    public ProductServiceImpl(ProductRepo productRepo, IngredientRepo ingredientRepo, DishRepo dishRepo) {
        this.productRepo = productRepo;
        this.ingredientRepo = ingredientRepo;
        this.dishRepo = dishRepo;
    }

    @Override
    public List<ProductDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, ProductDTO productDTO) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<ProductDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
