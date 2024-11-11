package pl.strefakursow.eLunchApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import pl.strefakursow.eLunchApp.config.JpaConfiguration;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;
import pl.strefakursow.eLunchApp.service.DelivererService;
import pl.strefakursow.eLunchApp.service.DelivererServiceImpl;

@SpringBootTest(classes = {
        JpaConfiguration.class,
        DelivererControllerTest.class
})
public class DelivererControllerTest {
    @Configuration
    public static class Config {
        @Bean
        public DelivererService delivererService(DelivererRepo delivererRepo, OrderRepo orderRepo) {
            return new DelivererServiceImpl(delivererRepo, orderRepo);
        }

        @Bean
        public DelivererController delivererController(DelivererService delivererService) {
            return new DelivererController(delivererService);
        }
    }

    @Autowired
    private DelivererRepo delivererRepo;

    @Autowired
    private DelivererService delivererService;

    @Autowired
    private DelivererController delivererController;

    @Autowired
    private PlatformTransactionManager txManager;

    private static final String STR_UUID = "dd899038-1a83-40df-bade-05c8191130fb";
}
