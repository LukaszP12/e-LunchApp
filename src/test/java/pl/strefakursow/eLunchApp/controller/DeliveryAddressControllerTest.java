package pl.strefakursow.eLunchApp.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.DTO.DeliveryAddressDTO;
import pl.strefakursow.eLunchApp.config.JpaConfiguration;
import pl.strefakursow.eLunchApp.model.Deliverer;
import pl.strefakursow.eLunchApp.model.DeliveryAddress;
import pl.strefakursow.eLunchApp.model.User;
import pl.strefakursow.eLunchApp.model.enums.Archive;
import pl.strefakursow.eLunchApp.model.enums.Sex;
import pl.strefakursow.eLunchApp.repo.DeliveryAddressRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.service.DeliveryAddressService;
import pl.strefakursow.eLunchApp.service.DeliveryAddressServiceImpl;
import pl.strefakursow.eLunchApp.utils.AssertionUtils;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;
import pl.strefakursow.eLunchApp.utils.TestUtils;

import java.util.UUID;

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

    //     add
    @Test
    @Transactional
    public void put1() {
        User user = TestUtils.user("6b0f4911-be2b-48ae-9936-deb1d706e081",
                TestUtils.personalData("John", "Smith", Sex.MALE, "501-501-501", "jh512@gmail.com"), null,
                TestUtils.logginData("jSmith", "I@mIronM@n12"), Archive.CURRENT);
        userRepo.save(user);

        DeliveryAddressDTO deliveryAddressJson = TestUtils.deliveryAddressDTO(STR_UUID, "My address", "Street",
                "51", "", "00-000", "Warsaw", null, "Poland", null, ConverterUtils.convert(user));
        deliveryAddressController.put(UUID.fromString(STR_UUID), deliveryAddressJson);

        DeliveryAddressDTO deliveryAddressDB = deliveryAddressService.getByUuid(UUID.fromString(STR_UUID)).orElseThrow();
        AssertionUtils.assertEquals(deliveryAddressJson, deliveryAddressDB);
    }

    //     update
    @Test
    @Transactional
    public void put2() {
        User user = TestUtils.user("6b0f4911-be2b-48ae-9936-deb1d706e081",
                TestUtils.personalData("John", "Smith", Sex.MALE, "501-501-501", "jh512@gmail.com"), null,
                TestUtils.logginData("jSmith", "I@mIronM@n12"), Archive.CURRENT);
        userRepo.save(user);
        DeliveryAddress deliveryAddress = TestUtils.deliveryAddress(STR_UUID, "My address", "Street",
                "51", "", "00-000", "Warsaw", null, "Poland", null, user);

        DeliveryAddressDTO deliveryAddressJson = TestUtils.deliveryAddressDTO(STR_UUID, "My address", "Street",
                "511", "1", "00-001", "Warsaw1", "1", "Poland1", "1", ConverterUtils.convert(user));
        deliveryAddressController.put(UUID.fromString(STR_UUID, deliveryAddressJson));

        DeliveryAddressDTO deliveryAddressDB = deliveryAddressService.getByUuid(UUID.fromString(STR_UUID)).orElseThrow();
        AssertionUtils.assertEquals(deliveryAddressJson, deliveryAddressDB);
    }
}
