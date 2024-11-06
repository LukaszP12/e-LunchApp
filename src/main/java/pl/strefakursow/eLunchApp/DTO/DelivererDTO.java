package pl.strefakursow.eLunchApp.DTO;

import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.annotation.Nullable;
import java.util.List;

@GeneratePojoBuilder
public class DelivererDTO extends EmployeeDTO {

    @Nullable
    private List<OrderDTO> orderDTOS;

    @Nullable
    public List<OrderDTO> getOrders() {
        return orderDTOS;
    }

    public void setOrders(@Nullable List<OrderDTO> orderDTOS) {
        this.orderDTOS = orderDTOS;
    }
}
