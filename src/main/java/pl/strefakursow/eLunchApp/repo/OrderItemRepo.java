package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItemRepo, Long> {
    Optional<OrderItemRepo> findByUUID(UUID uuid);
}
