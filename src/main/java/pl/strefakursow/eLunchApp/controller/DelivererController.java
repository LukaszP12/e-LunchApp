package pl.strefakursow.eLunchApp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.DTO.LogginDataDTO;
import pl.strefakursow.eLunchApp.DTO.OrderDTO;
import pl.strefakursow.eLunchApp.DTO.PersonalDataDTO;
import pl.strefakursow.eLunchApp.service.DelivererService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequestMapping(value = "/api/deliverers", produces = APPLICATION_JSON_VALUE)
public class DelivererController {
    interface DelivererListView extends DelivererDTO.View.Basic, PersonalDataDTO.View.Basic {
    }

    interface DelivererView extends DelivererDTO.View.Extended, PersonalDataDTO.View.Extended, LogginDataDTO.View.Basic, OrderDTO.View.Extended {
    }

    interface NewDelivererValidation extends Default, DelivererDTO.NewDelivererValidation {
    }

    private final DelivererService delivererService;

    @Autowired
    public DelivererController(DelivererService delivererService) {
        this.delivererService = delivererService;
    }

    @JsonView(DelivererListView.class)
    @GetMapping
    public List<DelivererDTO> get() {
        return delivererService.getAll();
    }

    @JsonView(DelivererView.class)
    @GetMapping("/{uuid}")
    public DelivererDTO get(@PathVariable UUID uuid) {
        return delivererService.getByUUID(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Validated(DelivererDTO.NewDelivererValidation.class)
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody @Valid DelivererDTO json) {
        delivererService.put(uuid,json);
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        delivererService.delete(uuid);
    }
}
