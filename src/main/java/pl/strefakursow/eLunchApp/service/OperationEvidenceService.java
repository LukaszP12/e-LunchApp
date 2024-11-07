package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.model.OperationEvidence;
import pl.strefakursow.eLunchApp.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OperationEvidenceService {
    List<OperationEvidence> getAll();

    void put(UUID uuid, OperationEvidence operationEvidence);

    void delete(UUID uuid);

    Optional<OperationEvidence> getByUuid(UUID uuid);

    BigDecimal getUserAccountBalance(User user);

    BigDecimal getAccountBalanceAfterOperation(OperationEvidence operationEvidence);
}
