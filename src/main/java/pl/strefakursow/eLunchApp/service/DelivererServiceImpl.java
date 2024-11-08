package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.model.Deliverer;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return delivererRepo.findAll()
                .stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, DelivererDTO delivererDTO) {

    }

    @Override
    public void delete(UUID uuid) {
        Deliverer deliverer = delivererRepo.findByUUID(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        delivererRepo.deleteById(deliverer.getId());
    }

    @Override
    public Optional<DelivererDTO> getByUUID(UUID uuid) {
        return delivererRepo.findByUUID(uuid)
                .map(ConverterUtils::convert);
    }
}
