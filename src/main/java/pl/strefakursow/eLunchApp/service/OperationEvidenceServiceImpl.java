package pl.strefakursow.eLunchApp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.eLunchApp.model.OperationEvidence;
import pl.strefakursow.eLunchApp.model.User;
import pl.strefakursow.eLunchApp.repo.OperationEvidenceRepo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OperationEvidenceServiceImpl implements OperationEvidenceService {

    private final OperationEvidenceRepo operationEvidenceRepo;

    public OperationEvidenceServiceImpl(OperationEvidenceRepo operationEvidenceRepo) {
        this.operationEvidenceRepo = operationEvidenceRepo;
    }

    @Override
    public List<OperationEvidence> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, OperationEvidence operationEvidence) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<OperationEvidence> getByUuid(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public BigDecimal getUserAccountBalance(User user) {
        return null;
    }

    @Override
    public BigDecimal getAccountBalanceAfterOperation(OperationEvidence operationEvidence) {
        return null;
    }
}
