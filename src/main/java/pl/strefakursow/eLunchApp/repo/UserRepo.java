package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.strefakursow.eLunchApp.model.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUUID(UUID uuid);
}
