package pl.strefakursow.eLunchApp.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.eLunchApp.DTO.OrderDTO;
import pl.strefakursow.eLunchApp.DTO.ProductDTO;
import pl.strefakursow.eLunchApp.service.ProductService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/products", produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public ProductDTO get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody ProductDTO delivererJson) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

    }
}
