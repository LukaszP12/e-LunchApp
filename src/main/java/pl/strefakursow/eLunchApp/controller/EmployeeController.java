package pl.strefakursow.eLunchApp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.eLunchApp.DTO.DishDTO;
import pl.strefakursow.eLunchApp.DTO.EmployeeDTO;
import pl.strefakursow.eLunchApp.DTO.LogginDataDTO;
import pl.strefakursow.eLunchApp.DTO.MenuItemDTO;
import pl.strefakursow.eLunchApp.DTO.PersonalDataDTO;
import pl.strefakursow.eLunchApp.DTO.ProductDTO;
import pl.strefakursow.eLunchApp.service.EmployeeService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/employees", produces = APPLICATION_JSON_VALUE)
public class EmployeeController {
    interface EmployeeListView extends EmployeeDTO.View.Basic, PersonalDataDTO.View.Basic {}
    interface EmployeeView extends EmployeeDTO.View.Extended, PersonalDataDTO.View.Extended, LogginDataDTO.View.Basic {}

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public EmployeeDTO get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody @Valid EmployeeDTO json) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

    }
}
