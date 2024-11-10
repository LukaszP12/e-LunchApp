package pl.strefakursow.eLunchApp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Null;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.annotation.Nullable;
import java.util.List;

@GeneratePojoBuilder
public class DelivererDTO extends EmployeeDTO {

    public static class View {
        public interface Id extends EmployeeDTO.View.Id{}
        public interface Basic extends EmployeeDTO.View.Basic{}
        public interface Extended extends Basic,EmployeeDTO.View.Extended {}
    }

    public interface NewDelivererValidation {};

    @JsonView(View.Extended.class)
    @Nullable
    @Null(groups = NewDelivererValidation.class)
    private List<OrderDTO> orderDTOS;

    @Nullable
    public List<OrderDTO> getOrdersDtos() {
        return orderDTOS;
    }

    public void setOrdersDtos(@Nullable List<OrderDTO> orderDTOS) {
        this.orderDTOS = orderDTOS;
    }
}
