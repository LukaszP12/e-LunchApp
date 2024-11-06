package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OpenTimeRepo extends JpaRepository<OpenTimeRepo, Long> {
    Optional<OpenTimeRepo> findByUUID(UUID uuid);
}
