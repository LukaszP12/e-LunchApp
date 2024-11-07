package pl.strefakursow.eLunchApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.service.DelivererService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/deliverers", produces = APPLICATION_JSON_VALUE)
public class DelivererController {

    private final DelivererService delivererService;

    @Autowired
    public DelivererController(DelivererService delivererService) {
        this.delivererService = delivererService;
    }

    @GetMapping
    public List<DelivererDTO> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public DelivererDTO get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody DelivererDTO delivererJson) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        
    }
}