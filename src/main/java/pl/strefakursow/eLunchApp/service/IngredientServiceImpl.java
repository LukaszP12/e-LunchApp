package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.IngredientDTO;
import pl.strefakursow.eLunchApp.repo.IngredientRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepo ingredientRepo;

    public IngredientServiceImpl(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

//    @Override
//    public List<IngredientDTO> getAll() {
//        return ingredientRepo.findAll().stream()
//                .map(ConverterUtils::convert)
//                .collect(Collectors.toList());
//    }


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
