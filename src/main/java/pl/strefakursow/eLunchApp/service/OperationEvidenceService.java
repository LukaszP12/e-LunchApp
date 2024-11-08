package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.model.OperationEvidence;
import pl.strefakursow.eLunchApp.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OperationEvidenceService {
    List<OperationEvidence> getAll();

    void add(OperationEvidence operationEvidence);

    void delete(OperationEvidence operationEvidence);

    BigDecimal getUserAccountBalance(User user);

    BigDecimal getAccountBalanceAfterOperation(OperationEvidence operationEvidence);
}
