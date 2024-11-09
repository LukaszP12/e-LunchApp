package pl.strefakursow.eLunchApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.DeliveryAddressDTO;
import pl.strefakursow.eLunchApp.model.DeliveryAddress;
import pl.strefakursow.eLunchApp.repo.DeliveryAddressRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private final DeliveryAddressRepo deliveryAddressRepo;
    private final UserRepo userRepo;

    public DeliveryAddressServiceImpl(DeliveryAddressRepo deliveryAddressRepo, UserRepo userRepo) {
        this.deliveryAddressRepo = deliveryAddressRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Optional<DeliveryAddressDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
//    @Override
//    public List<DeliveryAddressDTO> getAll() {
//        return deliveryAddressRepo.findAll().stream()
//                .map(ConverterUtils::convert)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<DeliveryAddressDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, DeliveryAddressDTO deliveryAddressDTO) {

    }

    @Override
    public void delete(UUID uuid) {
        DeliveryAddress deliveryAddress = deliveryAddressRepo.findByUUID(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        deliveryAddressRepo.deleteById(deliveryAddress.getId());
    }

//    @Override
//    public Optional<DeliveryAddressDTO> getByUuid(UUID uuid) {
//        return deliveryAddressRepo.findByUUID(uuid).map(ConverterUtils::convert);
//    }
}
