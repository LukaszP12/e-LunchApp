package pl.strefakursow.eLunchApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.eLunchApp.model.DeliveryAddress;
import pl.strefakursow.eLunchApp.model.LoginData;
import pl.strefakursow.eLunchApp.model.PersonalData;
import pl.strefakursow.eLunchApp.model.enums.Archive;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class UserDTO {

    public static class View {
        public interface Id { }
        public interface Basic extends Id { }
        public interface Extended extends Basic { }
    }

    @JsonView(View.Id.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Basic.class)
    @NotNull
    @Embedded
    private PersonalData personalData;

    @JsonView(View.Extended.class)
    @Nullable
    private List<DeliveryAddress> deliveryAddresses;

    @JsonView(View.Extended.class)
    @NotNull
    @Embedded
    private LoginData loginData;

    @JsonIgnore
    @Nullable
    private List<OrderDTO> orders;

    @JsonView(View.Extended.class)
    private List<OperationEvidenceDTO> operationEvidences;

    @JsonView(View.Extended.class)
    @Nullable
    private List<DiscountCodeDTO> discountCodes;

    @JsonView(View.Extended.class)
    @NotNull
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

    public LoginData getLogginData() {
        return loginData;
    }

    public void setLogginData(LoginData loginData) {
        this.loginData = loginData;
    }


    public @NotNull List<OperationEvidenceDTO> getOperationEvidences() {
        return operationEvidences;
    }

    public void setOperationEvidences(List<OperationEvidenceDTO> operationEvidences) {
        this.operationEvidences = operationEvidences;
    }

    @Nullable
    public List<DiscountCodeDTO> getDiscountCodes() {
        return discountCodes;
    }

    public void setDiscountCodes(@Nullable List<DiscountCodeDTO> discountCodes) {
        this.discountCodes = discountCodes;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

}
