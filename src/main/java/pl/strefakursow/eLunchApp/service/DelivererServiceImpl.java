package pl.strefakursow.eLunchApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.DTO.OrderDTO;
import pl.strefakursow.eLunchApp.model.Deliverer;
import pl.strefakursow.eLunchApp.model.DelivererBuilder;
import pl.strefakursow.eLunchApp.model.Order;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static pl.strefakursow.eLunchApp.utils.ConverterUtils.convert;

@Service
@CacheConfig(cacheNames = "deliverers")
public class DelivererServiceImpl implements DelivererService {
    private final DelivererRepo delivererRepo;
    private final OrderRepo orderRepo;

    @Autowired
    public DelivererServiceImpl(DelivererRepo delivererRepo, OrderRepo orderRepo) {
        this.delivererRepo = delivererRepo;
        this.orderRepo = orderRepo;
    }

    @Cacheable(cacheNames = "deliverers")
    @Override
    public List<DelivererDTO> getAll() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return delivererRepo.findAll()
                .stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "deliverers", allEntries = true)
    @Override
    public void put(UUID uuid, DelivererDTO delivererDTO) {
        if (!Objects.equals(delivererDTO.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Deliverer deliverer = delivererRepo.findByUUID(delivererDTO.getUuid())
                .orElseGet(() -> newDeliverer(delivererDTO.getUuid()));

        List<Order> orders = new ArrayList<>();
        if (delivererDTO.getOrdersDtos() != null) {
            for (OrderDTO o : delivererDTO.getOrdersDtos()) {
                Order order = orderRepo.findByUUID(o.getUuid())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                orders.add(order);
            }
        }

        deliverer.setPersonalData(convert(delivererDTO.getPersonalData()));
        deliverer.setLoginData(convert(delivererDTO.getLoginData()));
        deliverer.setArchive(delivererDTO.getArchive());
        deliverer.setOrders(orders);

        if (deliverer.getId() == null) {
            delivererRepo.save(deliverer);
        }
    }

    private Deliverer newDeliverer(UUID uuid) {
        return new DelivererBuilder()
                .withUuid(uuid)
                .build();
    }

    @CacheEvict(cacheNames = "deliverers", allEntries = true)
    @Override
    public void delete(UUID uuid) {
        Deliverer deliverer = delivererRepo.findByUUID(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        delivererRepo.delete(deliverer);
    }

    @Override
    public Optional<DelivererDTO> getByUUID(UUID uuid) {
        return delivererRepo.findByUUID(uuid)
                .map(ConverterUtils::convert);
    }
}
