package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.IngredientDTO;
import pl.strefakursow.eLunchApp.repo.IngredientRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepo ingredientRepo;

    public IngredientServiceImpl(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public List<IngredientDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, IngredientDTO ingredientDTO) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<IngredientDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
