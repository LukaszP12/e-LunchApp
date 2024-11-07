package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.DTO.DeliveryAddressDTO;
import pl.strefakursow.eLunchApp.repo.DeliveryAddressRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private final DeliveryAddressRepo deliveryAddressRepo;
    private final UserRepo userRepo;

    public DeliveryAddressServiceImpl(DeliveryAddressRepo deliveryAddressRepo, UserRepo userRepo) {
        this.deliveryAddressRepo = deliveryAddressRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<DeliveryAddressDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, DeliveryAddressDTO deliveryAddressDTO) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<DeliveryAddressDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
