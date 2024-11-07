package pl.strefakursow.eLunchApp.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.eLunchApp.DTO.OpenTimeDTO;
import pl.strefakursow.eLunchApp.service.OpenTimeService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/open-time", produces = APPLICATION_JSON_VALUE)
public class OpenTimeController {

    private OpenTimeService openTimeService;

    public OpenTimeController(OpenTimeService openTimeService) {
        this.openTimeService = openTimeService;
    }

    @GetMapping
    public List<OpenTimeDTO> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public OpenTimeDTO get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody OpenTimeDTO delivererJson) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

    }
}
