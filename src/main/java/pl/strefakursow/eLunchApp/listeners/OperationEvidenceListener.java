package pl.strefakursow.eLunchApp.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.events.OperationEvidenceCreator;
import pl.strefakursow.eLunchApp.model.OperationEvidence;
import pl.strefakursow.eLunchApp.model.User;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.service.OperationEvidenceService;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.math.BigDecimal;

@Component
public class OperationEvidenceListener {

    private final OperationEvidenceService operationEvidenceService;
    private final UserRepo userRepo;

    @Autowired
    public OperationEvidenceListener(OperationEvidenceService operationEvidenceService, UserRepo userRepo) {
        this.operationEvidenceService = operationEvidenceService;
        this.userRepo = userRepo;
    }

    @EventListener
    public void onAddOperation(OperationEvidenceCreator operationEvidenceCreator) {
//        UserDTO userDTO = operationEvidenceCreator.getUserDTO();
//        OperationEvidence operationEvidence = ConverterUtils.convert(userDTO.getOperationEvidence().stream().findFirst().orElseThrow());
//        User user = userRepo.findByUUID(userDTO.getUuid()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
//        operationEvidence.setUser(user);
//
//        validateAccountBalanceAfterOperation(operationEvidence);
//        operationEvidenceService.add(operationEvidence);
    }

    private void validateAccountBalanceAfterOperation(OperationEvidence operationEvidence) {
        BigDecimal accountBalanceAfterOperation = operationEvidenceService.getAccountBalanceAfterOperation(operationEvidence);
        if (accountBalanceAfterOperation.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
