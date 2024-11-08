package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.ProductDTO;
import pl.strefakursow.eLunchApp.model.Product;
import pl.strefakursow.eLunchApp.repo.DishRepo;
import pl.strefakursow.eLunchApp.repo.IngredientRepo;
import pl.strefakursow.eLunchApp.repo.ProductRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return productRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, ProductDTO productDTO) {

    }

    @Override
    public void delete(UUID uuid) {
        Product product = productRepo.findByUUID(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        productRepo.deleteById(product.getId());
    }

    @Override
    public Optional<ProductDTO> getByUuid(UUID uuid) {
        return productRepo
                .findByUUID(uuid)
                .map(ConverterUtils::convert);
    }
}
