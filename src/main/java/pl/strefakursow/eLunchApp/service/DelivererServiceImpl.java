package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DelivererServiceImpl implements DelivererService {

    private final DelivererRepo delivererRepo;
    private final OrderRepo orderRepo;

    public DelivererServiceImpl(DelivererRepo delivererRepo, OrderRepo orderRepo) {
        this.delivererRepo = delivererRepo;
        this.orderRepo = orderRepo;
    }

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
