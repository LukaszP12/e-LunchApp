package pl.strefakursow.eLunchApp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.DeliveryAddressDTO;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.service.DeliveryAddressService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/delivery-address", produces = APPLICATION_JSON_VALUE)
public class DeliveryAddressController {
    interface DeliveryAddressListView extends DeliveryAddressDTO.View.Basic, UserDTO.View.Id {}
    interface DeliveryAddressView extends DeliveryAddressDTO.View.Extended, UserDTO.View.Id {}

    private final DeliveryAddressService deliveryAddressService;

    @Autowired
    public DeliveryAddressController(DeliveryAddressService deliveryAddressService) {
        this.deliveryAddressService = deliveryAddressService;
    }

    @JsonView(DelivererController.DelivererListView.class)
    @GetMapping
    public List<DeliveryAddressDTO> get() {
        return deliveryAddressService.getAll();
    }

    @JsonView(DeliveryAddressView.class)
    @GetMapping("/{uuid}")
    public DeliveryAddressDTO get(@PathVariable UUID uuid) {
        return deliveryAddressService.getByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody DeliveryAddressDTO json) {
        deliveryAddressService.put(uuid, json);
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        deliveryAddressService.delete(uuid);
    }
}
