package pl.strefakursow.eLunchApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DelivererServiceImpl implements DelivererService {

    @Autowired
    private DelivererRepo delivererRepo;

    @Override
    public List<DelivererDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, DelivererDTO delivererDTO) {

    }

    @Override
    public void delete(UUID uuid) {
    }

    @Override
    public Optional<DelivererDTO> getByUUID(UUID uuid) {
        return Optional.empty();
    }
}
