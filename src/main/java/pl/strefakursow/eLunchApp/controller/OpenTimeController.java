package pl.strefakursow.eLunchApp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.DishDTO;
import pl.strefakursow.eLunchApp.DTO.MenuItemDTO;
import pl.strefakursow.eLunchApp.DTO.OpenTimeDTO;
import pl.strefakursow.eLunchApp.DTO.RestaurantDTO;
import pl.strefakursow.eLunchApp.service.OpenTimeService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/open-time", produces = APPLICATION_JSON_VALUE)
public class OpenTimeController {
    interface OpenTimeListView extends OpenTimeDTO.View.Basic {
    }

    interface OpenTimeView extends MenuItemDTO.View.Extended, RestaurantDTO.View.Id {
    }

    private OpenTimeService openTimeService;

    @Autowired
    public OpenTimeController(OpenTimeService openTimeService) {
        this.openTimeService = openTimeService;
    }

    @JsonView(OpenTimeListView.class)
    @GetMapping
    public List<OpenTimeDTO> get() {
        return openTimeService.getAll();
    }

    //ToDO post
    @Transactional
    @PostMapping
    public void post(@RequestBody List<@Valid OpenTimeDTO> openTimesJson) {
        for (OpenTimeDTO openTimeDTO : openTimesJson) {
            put(openTimeDTO.getUuid(),openTimeDTO);
        }
    }

    @JsonView(OpenTimeView.class)
    @GetMapping("/{uuid}")
    public OpenTimeDTO get(@PathVariable UUID uuid) {
        return openTimeService.getByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody @Valid OpenTimeDTO json) {
        openTimeService.put(uuid, json);
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        openTimeService.delete(uuid);
    }

    //TODO patchIsPaid

    //TODO patchIsGivenOut

    //TODO patchIsDelivered
}
