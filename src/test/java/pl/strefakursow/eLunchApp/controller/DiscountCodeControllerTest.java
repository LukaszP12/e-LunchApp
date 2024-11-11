package pl.strefakursow.eLunchApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import pl.strefakursow.eLunchApp.config.JpaConfiguration;
import pl.strefakursow.eLunchApp.repo.DeliveryAddressRepo;
import pl.strefakursow.eLunchApp.repo.DiscountCodeRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.service.DiscountCodeService;
import pl.strefakursow.eLunchApp.service.DiscountCodeServiceImpl;

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
}
