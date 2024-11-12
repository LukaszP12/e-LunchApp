package pl.strefakursow.eLunchApp.controller;

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
import pl.strefakursow.eLunchApp.model.User;
import pl.strefakursow.eLunchApp.model.enums.Archive;
import pl.strefakursow.eLunchApp.model.enums.Sex;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;
import pl.strefakursow.eLunchApp.repo.OrderRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.service.DelivererService;
import pl.strefakursow.eLunchApp.service.DelivererServiceImpl;
import pl.strefakursow.eLunchApp.utils.AssertionUtils;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;
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

    @Autowired
    private UserRepo userRepo;

    // add
    @Test
    @Transactional
    public void put1() {
        User user = TestUtils.user("f0fb16b2-55f5-4ade-a796-4031caa10a2a",
                TestUtils.personalData("John", "Smith", Sex.MALE, "501-501-501", "jh512@gmail.com"),
                null, TestUtils.logginData("jSmith", "I@mIronM@n12"), Archive.CURRENT);
        userRepo.save(user);

        DelivererDTO delivererJson = TestUtils.deliveryAddressDTO(STR_UUID,"My Address","Street",
                "51",null,"00-000","Warsaw",null,"Poland",null,
                ConverterUtils.convert(user));
        delivererController.put(UUID.fromString(STR_UUID), delivererJson);

        DelivererDTO delivererDB = delivererService.getByUUID(UUID.fromString(STR_UUID)).orElseThrow();
        AssertionUtils.assertEquals(delivererJson, delivererDB);
    }

    // update
    @Test
    @Transactional
    public void put2() {
        Deliverer deliverer = TestUtils.deliverer(STR_UUID,
                TestUtils.personalDataDTO("John", "Smith", Sex.MALE, "501-501-501", "john512@gmail.coom"),
                TestUtils.logginDataDTO("jSmith", "I@mIronM@n12"), Archive.CURRENT);
        delivererRepo.save(deliverer);

        DelivererDTO delivererJson = TestUtils.delivererDTO(STR_UUID,
                TestUtils.personalDataDTO("John1", "Smith1", Sex.FEMALE, "501-501-501", "jh5123@gmail.com"),
                TestUtils.logginDataDTO("jSmith1", "I@mIronM@n12"), Archive.ARCHIVE);
        delivererController.put(UUID.fromString(STR_UUID), delivererJson);

        DelivererDTO delivererDB = delivererService.getByUUID(UUID.fromString(STR_UUID)).orElseThrow();
        AssertionUtils.assertEquals(delivererJson, delivererDB);
    }
}
