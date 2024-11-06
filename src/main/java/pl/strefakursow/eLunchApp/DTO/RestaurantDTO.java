package pl.strefakursow.eLunchApp.DTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.eLunchApp.model.enums.Archive;

import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class RestaurantDTO {

    private Long id;

    @NotNull
    private UUID uuid;

    @NotBlank
    private String name;

    @NotNull
    @Embedded
    private LoginDataDTO loginDataDTO;

    @NotNull
    @Embedded
    private CompanyDataDTO companyData;

    @NotNull
    @Size(max = 7)
    private List<OpenTimeDTO> openTimeDTOS;

    @NotNull
    private List<OrderDTO> orderDTOS;

    @NotNull
    private List<MenuItemDTO> menuItemDTOS;

    @NotNull
    private List<DiscountCodeDTO> discountCodeDTOS;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Archive archive;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoginDataDTO getLogginData() {
        return loginDataDTO;
    }

    public void setLogginData(LoginDataDTO loginDataDTO) {
        this.loginDataDTO = loginDataDTO;
    }

    public CompanyDataDTO getCompanyData() {
        return companyData;
    }

    public void setCompanyData(CompanyDataDTO companyData) {
        this.companyData = companyData;
    }

    public List<OpenTimeDTO> getOpenTimes() {
        return openTimeDTOS;
    }

    public void setOpenTimes(List<OpenTimeDTO> openTimeDTOS) {
        this.openTimeDTOS = openTimeDTOS;
    }

    public List<OrderDTO> getOrders() {
        return orderDTOS;
    }

    public void setOrders(List<OrderDTO> orderDTOS) {
        this.orderDTOS = orderDTOS;
    }

    public List<MenuItemDTO> getMenuItems() {
        return menuItemDTOS;
    }

    public void setMenuItems(List<MenuItemDTO> menuItemDTOS) {
        this.menuItemDTOS = menuItemDTOS;
    }

    public List<DiscountCodeDTO> getDiscountCodes() {
        return discountCodeDTOS;
    }

    public void setDiscountCodes(List<DiscountCodeDTO> discountCodeDTOS) {
        this.discountCodeDTOS = discountCodeDTOS;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }
}
