package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.strefakursow.eLunchApp.model.Deliverer;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DelivererRepo extends JpaRepository<Deliverer, Long> {
    Optional<Deliverer> findByUUID(UUID uuid);
}
