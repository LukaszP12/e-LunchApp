package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.DTO.ProductDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<ProductDTO> getAll();

    void put(UUID uuid, ProductDTO productDTO);

    void delete(UUID uuid);

    Optional<ProductDTO> getByUuid(UUID uuid);
}
