package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderItem extends JpaRepository<OrderItem, Long> {
    Optional<OrderItem> findByUUID(UUID uuid);
}
