package pl.strefakursow.eLunchApp.DTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import pl.strefakursow.eLunchApp.model.enums.Archive;

import java.util.UUID;

public class EmployeeDTO {

    private Long id;

    @NotNull
    private UUID uuid;

    @NotNull
    @Embedded
    private PersonalDataDTO personalDataDTO;

    @NotNull
    @Embedded
    private LoginDataDTO loginDataDTO;

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

    public PersonalDataDTO getPersonalData() {
        return personalDataDTO;
    }

    public void setPersonalData(PersonalDataDTO personalDataDTO) {
        this.personalDataDTO = personalDataDTO;
    }

    public LoginDataDTO getLoginData() {
        return loginDataDTO;
    }

    public void setLoginData(LoginDataDTO loginDataDTO) {
        this.loginDataDTO = loginDataDTO;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }
}
