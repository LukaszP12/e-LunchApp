package pl.strefakursow.eLunchApp.DTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import pl.strefakursow.eLunchApp.model.DeliveryAddress;
import pl.strefakursow.eLunchApp.model.DiscountCode;
import pl.strefakursow.eLunchApp.model.LoginData;
import pl.strefakursow.eLunchApp.model.OperationEvidence;
import pl.strefakursow.eLunchApp.model.PersonalData;
import pl.strefakursow.eLunchApp.model.enums.Archive;


import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class UserDTO {

    @NotNull
    private UUID uuid;

    @NotNull
    @Embedded
    private PersonalData personalData;

    @Nullable
    private List<DeliveryAddress> addresses;

    @NotNull
    @Embedded
    private LoginData loginData;

    @Nullable
    private List<OrderDTO> orderDTOS;

    @NotNull
    private List<OperationEvidence> operationEvidences;

    @Nullable
    private List<DiscountCode> discountCodes;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Archive archive;


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
    public List<OrderDTO> getOrders() {
        return orderDTOS;
    }

    public void setOrders(@Nullable List<OrderDTO> orderDTOS) {
        this.orderDTOS = orderDTOS;
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
