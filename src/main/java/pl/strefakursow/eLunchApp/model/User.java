package pl.strefakursow.eLunchApp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import pl.strefakursow.eLunchApp.model.enums.Archive;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull
    private UUID uuid;

    @NotNull
    @Embedded
    private PersonalData personalData;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeliveryAddress> addresses;

    @NotNull
    @Embedded
    private LoginData loginData;

    @Nullable
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @NotNull
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OperationEvidence> operationEvidences;

    @Nullable
    @ManyToMany(mappedBy = "users")
    private List<DiscountCode> discountCodes;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Archive archive;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    @Nullable
    public List<DeliveryAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(@Nullable List<DeliveryAddress> addresses) {
        this.addresses = addresses;
    }

    public LoginData getLogginData() {
        return loginData;
    }

    public void setLogginData(LoginData loginData) {
        this.loginData = loginData;
    }

    @Nullable
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(@Nullable List<Order> orders) {
        this.orders = orders;
    }

    public List<OperationEvidence> getOperationEvidences() {
        return operationEvidences;
    }

    public void setOperationEvidences(List<OperationEvidence> operationEvidences) {
        this.operationEvidences = operationEvidences;
    }

    @Nullable
    public List<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }

    public void setDiscountCodes(@Nullable List<DiscountCode> discountCodes) {
        this.discountCodes = discountCodes;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

}
