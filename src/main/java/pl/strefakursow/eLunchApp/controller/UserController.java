package pl.strefakursow.eLunchApp.controller;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.eLunchApp.DTO.DeliveryAddressDTO;
import pl.strefakursow.eLunchApp.DTO.DiscountCodeDTO;
import pl.strefakursow.eLunchApp.DTO.LogginDataDTO;
import pl.strefakursow.eLunchApp.DTO.OperationEvidenceDTO;
import pl.strefakursow.eLunchApp.DTO.PersonalDataDTO;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.service.UserService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequestMapping(value = "/api/users", produces = APPLICATION_JSON_VALUE)
public class UserController {
    interface UserListView extends UserDTO.View.Basic, PersonalDataDTO.View.Basic {}
    interface UserView extends UserDTO.View.Extended, PersonalDataDTO.View.Extended, LogginDataDTO.View.Basic,
            DeliveryAddressDTO.View.Basic, OperationEvidenceDTO.View.Extended, DiscountCodeDTO.View.Extended {}

    interface DataUpdateValidation extends Default,UserDTO.DataUpdateValidation {}
    interface NewOperationValidation extends Default,UserDTO.NewOperationValidation {}

    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public UserController(UserService userService, ApplicationEventPublisher applicationEventPublisher) {
        this.userService = userService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping
    public List<UserDTO> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public UserDTO get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @Validated(DataUpdateValidation.class)
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody @Valid UserDTO json) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

    }
}
