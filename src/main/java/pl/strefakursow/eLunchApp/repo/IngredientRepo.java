package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.strefakursow.eLunchApp.model.Ingredient;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByUUID(UUID uuid);
}
