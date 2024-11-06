package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.strefakursow.eLunchApp.model.DeliveryAddress;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeliveryAddressRepo extends JpaRepository<DeliveryAddress, Long> {
    Optional<DeliveryAddress> findByUUID(UUID uuid);
}
