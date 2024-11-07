package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.DTO.OperationEvidenceDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OperationEvidenceService {
    List<OperationEvidenceDTO> getAll();

    void put(UUID uuid, OperationEvidenceDTO operationEvidenceDTO);

    void delete(UUID uuid);

    Optional<OperationEvidenceDTO> getByUuid(UUID uuid);
}
