package pl.strefakursow.eLunchApp.controller;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.DTO.DiscountCodeDTO;
import pl.strefakursow.eLunchApp.DTO.DishDTO;
import pl.strefakursow.eLunchApp.DTO.MenuItemDTO;
import pl.strefakursow.eLunchApp.DTO.PeriodDTO;
import pl.strefakursow.eLunchApp.DTO.ProductDTO;
import pl.strefakursow.eLunchApp.service.DishService;
import pl.strefakursow.eLunchApp.service.MenuItemService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequestMapping(value = "/api/dishes", produces = APPLICATION_JSON_VALUE)
public class DishController {
    interface DishListView extends DishDTO.View.Basic {}
    interface DishView extends DishDTO.View.Extended, ProductDTO.View.Extended, MenuItemDTO.View.Basic {}

    private DishService dishService;

    interface DishDataUpdateValidation extends Default,DishDTO.DataUpdateValidation {}

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<DishDTO> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public DishDTO get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @Validated(DishDataUpdateValidation.class)
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody @Valid DishDTO json) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

    }
}
