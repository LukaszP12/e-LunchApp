package pl.strefakursow.eLunchApp.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.eLunchApp.model.User;
import pl.strefakursow.eLunchApp.model.enums.EvidenceType;

import java.math.BigDecimal;
import java.time.Instant;

@GeneratePojoBuilder
public class OperationEvidenceDTO {

    private Long id;

    @NotNull
    private Instant date;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EvidenceType type;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    private BigDecimal amount;

    @NotNull
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public EvidenceType getType() {
        return type;
    }

    public void setType(EvidenceType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
