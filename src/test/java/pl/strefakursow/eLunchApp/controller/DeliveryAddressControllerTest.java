package pl.strefakursow.eLunchApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import pl.strefakursow.eLunchApp.config.JpaConfiguration;
import pl.strefakursow.eLunchApp.repo.DeliveryAddressRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.service.DeliveryAddressService;
import pl.strefakursow.eLunchApp.service.DeliveryAddressServiceImpl;

@SpringBootTest(classes = {
        JpaConfiguration.class,
        DeliveryAddressControllerTest.class
})
public class DeliveryAddressControllerTest {
    @Configuration
    public static class Config {
        @Bean
        public DeliveryAddressService deliveryAddressService(DeliveryAddressRepo deliveryAddressRepo, UserRepo userRepo) {
            return new DeliveryAddressServiceImpl(deliveryAddressRepo, userRepo);
        }

        @Bean
        public DeliveryAddressController deliveryAddressController(DeliveryAddressService deliveryAddressService) {
            return new DeliveryAddressController(deliveryAddressService);
        }
    }

    @Autowired
    private DeliveryAddressRepo deliveryAddressRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @Autowired
    private DeliveryAddressController deliveryAddressController;

    @Autowired
    private PlatformTransactionManager txManager;

    private static final String STR_UUID = "2b9d1887-02d8-4eb6-b5b9-b1e7e6ec7616";
}
