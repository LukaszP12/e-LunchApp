package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DiscountCode extends JpaRepository<DiscountCode, Long> {
    Optional<DiscountCode> findByUUID(UUID uuid);
}