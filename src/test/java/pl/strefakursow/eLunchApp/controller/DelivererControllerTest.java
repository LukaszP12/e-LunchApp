package pl.strefakursow.eLunchApp.controller;

import org.apache.catalina.webresources.AbstractResource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.config.JpaConfiguration;
import pl.strefakursow.eLunchApp.model.Deliverer;
import pl.strefakursow.eLunchApp.model.enums.Archive;
import pl.strefakursow.eLunchApp.model.enums.Sex;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;
import pl.strefakursow.eLunchApp.service.DelivererService;
import pl.strefakursow.eLunchApp.service.DelivererServiceImpl;
import pl.strefakursow.eLunchApp.utils.AssertionUtils;
import pl.strefakursow.eLunchApp.utils.TestUtils;

import java.util.UUID;

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

    @Test
    @Transactional
    public void put1() {
        DelivererDTO delivererJson = TestUtils.delivererDTO(STR_UUID,
                TestUtils.personalDataDTO("John", "Smith", Sex.MALE, "501-501-501", "john512@gmail.coom"),
                TestUtils.logginDataDTO("jSmith", "I@mIronM@n12"),
                Archive.CURRENT);
        delivererController.put(UUID.fromString(STR_UUID), delivererJson);

        DelivererDTO delivererDB = delivererService.getByUUID(UUID.fromString(STR_UUID)).orElseThrow();
        AssertionUtils.assertEquals(delivererJson, delivererDB);
    }

    @Test
    @Transactional
    public void put2() {
        Deliverer deliverer = TestUtils.deliverer(STR_UUID,
                TestUtils.personalDataDTO("John", "Smith", Sex.MALE, "501-501-501", "john512@gmail.coom"),
                TestUtils.logginDataDTO("jSmith", "I@mIronM@n12"), Archive.CURRENT);
        delivererRepo.save(deliverer);

        DelivererDTO delivererJson = TestUtils.delivererDTO(STR_UUID,
                TestUtils.personalDataDTO("John1", "Smith1", Sex.MALE, "501-501-501", "jh512@gmail.com"),
                TestUtils.logginDataDTO("jSmith", "I@mIronM@n12"), Archive.CURRENT);
        delivererController.put(UUID.fromString(STR_UUID), delivererJson);
    }
}
