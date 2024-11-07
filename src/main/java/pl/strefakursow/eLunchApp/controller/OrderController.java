package pl.strefakursow.eLunchApp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.DTO.OrderDTO;
import pl.strefakursow.eLunchApp.DTO.OrderStatusDTO;
import pl.strefakursow.eLunchApp.DTO.RestaurantDTO;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.service.DelivererService;
import pl.strefakursow.eLunchApp.service.OrderService;
import pl.strefakursow.eLunchApp.service.UserService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequestMapping(value = "/api/orders", produces = APPLICATION_JSON_VALUE)
public class OrderController {
    interface OrderListView extends OrderDTO.View.Basic, UserDTO.View.Id, DelivererDTO.View.Id, RestaurantDTO.View.Id {
    }

    interface OrderView extends OrderDTO.View.Extended, UserDTO.View.Id, DelivererDTO.View.Id, RestaurantDTO.View.Id {
    }

    private final OrderService orderService;
    private final DelivererService delivererService;
    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    interface OrderDataUpdateValidation extends Default, OrderDTO.OrderValidation {
    }

    interface OrderStatusValidation extends Default, OrderDTO.OrderStatusValidation {
    }

    interface GiveOutValidation extends Default, OrderDTO.OrderStatusValidation, OrderStatusDTO.GiveOutStatusValidation {
    }

    interface DeliveryValidation extends Default, OrderDTO.OrderStatusValidation, OrderStatusDTO.GiveOutStatusValidation {
    }

    @Autowired
    public OrderController(OrderService orderService, DelivererService delivererService, UserService userService, ApplicationEventPublisher applicationEventPublisher) {
        this.orderService = orderService;
        this.delivererService = delivererService;
        this.userService = userService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @JsonView(OrderListView.class)
    @GetMapping
    public List<OrderDTO> get() {
        return orderService.getAll();
    }

    // TODO getByUser

    @JsonView(OrderListView.class)
    @GetMapping(params = {"user"})
    public List<OrderDTO> getByUser(@RequestParam("user") UUID userUuid) {
        UserDTO user = userService.getByUuid(userUuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return user.getOrders();
    }

    // TODO getByDeliverer

    @JsonView(OrderListView.class)
    @GetMapping(params = {"deliverer"})
    public List<OrderDTO> getByDeliverer(@RequestParam("deliverer") UUID delivererUuid) {
        DelivererDTO delivererDTO = delivererService.getByUUID(delivererUuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return delivererDTO.getOrders();
    }

    @JsonView(OrderView.class)
    @GetMapping("/{uuid}")
    public OrderDTO get(@PathVariable UUID uuid) {
        return orderService.getByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Validated(OrderDataUpdateValidation.class)
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody @Valid OrderDTO json) {
        orderService.put(uuid, json);
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        orderService.delete(uuid);
    }

    //TODO patchIdPaid
    @Transactional
    @Validated(OrderStatusValidation.class)
    @PatchMapping("/{uuid}/paid")
    public void patchIsPaid(@PathVariable UUID uuid) {
        OrderDTO orderDTO = orderService.getByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderService.setIsPaid(orderDTO);
    }

    //TODO patchIsGivenOut
    @Transactional
    @Validated(GiveOutValidation.class)
    @PatchMapping("/{uuid}/IsGivenOut")
    public void patchIsGivenOut(@PathVariable UUID uuid,@RequestBody @Valid OrderStatusDTO orderStatusJson) {
        orderService.setIsGivenOut(uuid,orderStatusJson);
    }

    //TODO patchIsDelivered
    @Transactional
    @Validated(DeliveryValidation.class)
    @PatchMapping("/{uuid}/IsDelivered")
    public void patchIsDelivered(@PathVariable UUID uuid,@RequestBody @Valid OrderStatusDTO orderStatusJson) {
        orderService.setIsDelivered(uuid,orderStatusJson);
    }
}
