package pl.strefakursow.eLunchApp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.eLunchApp.model.enums.Archive;

import java.util.UUID;

@GeneratePojoBuilder
public class EmployeeDTO {

    public static class View {
        public interface Id {}
        public interface Basic extends Id {}
        public interface Extended extends DeliveryAddressDTO.View.Basic {}
    }

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Basic.class)
    @NotNull
    @Embedded
    private PersonalDataDTO personalDataDTO;

    @JsonView(View.Extended.class)
    @NotNull
    @Embedded
    private LogginDataDTO logginDataDTO;

    @JsonView(View.Extended.class)
    @NotNull
    @Enumerated(EnumType.STRING)
    private Archive archive;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public PersonalDataDTO getPersonalData() {
        return personalDataDTO;
    }

    public void setPersonalData(PersonalDataDTO personalDataDTO) {
        this.personalDataDTO = personalDataDTO;
    }

    public LogginDataDTO getLoginData() {
        return logginDataDTO;
    }

    public void setLoginData(LogginDataDTO logginDataDTO) {
        this.logginDataDTO = logginDataDTO;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }
}
