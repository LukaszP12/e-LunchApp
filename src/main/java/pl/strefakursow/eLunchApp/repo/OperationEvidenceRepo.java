package pl.strefakursow.eLunchApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.strefakursow.eLunchApp.model.OperationEvidence;
import pl.strefakursow.eLunchApp.model.User;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OperationEvidenceRepo extends JpaRepository<OperationEvidence, Long> {

    Optional<OperationEvidence> findByUUID(UUID uuid);

    @Query("SELECT COALESCE(SUM(CASE WHEN e.type = pl.strefakursow.eLunchApp.model.enums.EvidenceType.DEPOSIT THEN e.amount" +
            "WHEN e.type = pl.strefakursow.eLunchApp.model.enums.EvidenceType.WITHDRAW" +
            "or pl.strefakursow.eLunchApp.model.enums.EvidenceType.PAYMENT THEN -e.amount" +
            "ELSE 0 " +
            "END" +
            "),0) from operationevidence e" +
            "WHERE e.user =: user"
    )
    BigDecimal getUserAccountBalance(@Param("user") User user);
}
