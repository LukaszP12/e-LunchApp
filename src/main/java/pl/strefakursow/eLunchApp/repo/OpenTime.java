package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OpenTime extends JpaRepository<OpenTime, Long> {
    Optional<OpenTime> findByUUID(UUID uuid);
}
