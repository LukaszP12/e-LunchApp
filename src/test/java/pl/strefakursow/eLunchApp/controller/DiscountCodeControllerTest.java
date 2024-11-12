package pl.strefakursow.eLunchApp.controller;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import pl.strefakursow.eLunchApp.DTO.DiscountCodeDTO;
import pl.strefakursow.eLunchApp.config.JpaConfiguration;
import pl.strefakursow.eLunchApp.model.DiscountCode;
import pl.strefakursow.eLunchApp.model.enums.DiscountUnit;
import pl.strefakursow.eLunchApp.repo.DeliveryAddressRepo;
import pl.strefakursow.eLunchApp.repo.DiscountCodeRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.service.DiscountCodeService;
import pl.strefakursow.eLunchApp.service.DiscountCodeServiceImpl;
import pl.strefakursow.eLunchApp.utils.TestUtils;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest(classes = {
        JpaConfiguration.class,
        DiscountCodeControllerTest.Config.class
})
public class DiscountCodeControllerTest {
    @Configuration
    public static class Config {
        @Bean
        public DiscountCodeService discountCodeService(DiscountCodeRepo discountCodeRepo,
                                                       UserRepo userRepo,
                                                       RestaurantRepo restaurantRepo,
                                                       DeliveryAddressRepo deliveryAddressRepo,
                                                       OrderRepo orderRepo) {
            return new DiscountCodeServiceImpl(discountCodeRepo, userRepo, restaurantRepo, deliveryAddressRepo);
        }

        @Bean
        public DiscountCodeController discountCodeController(DiscountCodeService discountCodeService) {
            return new DiscountCodeController(discountCodeService);
        }
    }

    @Autowired
    private DiscountCodeRepo discountCodeRepo;

    @Autowired
    private DiscountCodeService discountCodeService;

    @Autowired
    private DiscountCodeController discountCodeController;

    @Autowired
    private PlatformTransactionManager txManager;

    private static final String STR_UUID = "a018bd0f-fe55-4979-89f5-55feca0f9263";

    // add
    @Test
    public void put1() {
        DiscountCodeDTO discountCodeJson = TestUtils.discountCodeDTO(STR_UUID, "BLACK FRIDAY", new BigDecimal("25.00"), DiscountUnit.PERCENT,
                "2020-01-01T00:00:00", "2020-02-01T00:00:00", null, null);
        discountCodeController.put(UUID.fromString(STR_UUID), discountCodeJson);

        DiscountCodeDTO discountCodeDB = discountCodeService.getByUuid(UUID.fromString(STR_UUID)).orElseThrow();
        Assertions.assertEquals(discountCodeJson, discountCodeDB);
    }

    // update
    @Test
    public void put2() {
        DiscountCode discountCode = TestUtils.discountCode(STR_UUID, "BLACK FRIDAY", new BigDecimal("25.00"),
                DiscountUnit.PERCENT, "2020-01-01T00:00:00", "2020-02-01T00:00:00", null, null);
        discountCodeRepo.save(discountCode);

        DiscountCodeDTO discountCodeJson = TestUtils.discountCodeDTO(STR_UUID, "BLACK FRIDAY1", new BigDecimal("20.00"), DiscountUnit.PLN,
                "2020-05-01T00:00:00", "2020-06-01T00:00:00", null, null);
        discountCodeController.put(UUID.fromString(STR_UUID), discountCodeJson);

        DiscountCodeDTO discountCodeDB = discountCodeService.getByUuid(UUID.fromString(STR_UUID)).orElseThrow();
        Assertions.assertEquals(discountCodeJson, discountCodeDB);
    }
}
