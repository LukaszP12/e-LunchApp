package pl.strefakursow.eLunchApp.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.strefakursow.eLunchApp.config.JpaConfiguration;
import pl.strefakursow.eLunchApp.listeners.OperationEvidenceListener;
import pl.strefakursow.eLunchApp.repo.OperationEvidenceRepo;
import pl.strefakursow.eLunchApp.repo.OrderItemRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.service.DelivererService;
import pl.strefakursow.eLunchApp.service.OperationEvidenceService;
import pl.strefakursow.eLunchApp.service.OperationEvidenceServiceImpl;
import pl.strefakursow.eLunchApp.service.OrderItemService;
import pl.strefakursow.eLunchApp.service.OrderItemServiceImpl;

@SpringBootTest(classes = {
        JpaConfiguration.class,
        OrderControllerTest.class
})
public class OrderControllerTest {
    @Configuration
    public static class Config {
        @Bean
        public OperationEvidenceService operationEvidenceService(OperationEvidenceRepo operationEvidenceRepo) {
            return new OperationEvidenceServiceImpl(operationEvidenceRepo);
        }

        @Bean
        public DelivererController delivererController(DelivererService delivererService) {
            return new DelivererController(delivererService);
        }

        @Bean
        public OrderItemService orderItemService(OrderItemRepo orderItemRepo) {
            return new OrderItemServiceImpl(orderItemRepo);
        }

        @Bean
        public OperationEvidenceListener operationEvidenceListener(OperationEvidenceService operationEvidenceService, UserRepo userRepo) {
            return new OperationEvidenceListener(operationEvidenceService, userRepo);
        }
    }
}
