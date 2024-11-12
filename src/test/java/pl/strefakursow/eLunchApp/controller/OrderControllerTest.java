package pl.strefakursow.eLunchApp.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import pl.strefakursow.eLunchApp.config.JpaConfiguration;
import pl.strefakursow.eLunchApp.listeners.OperationEvidenceListener;
import pl.strefakursow.eLunchApp.model.Deliverer;
import pl.strefakursow.eLunchApp.model.DeliveryAddress;
import pl.strefakursow.eLunchApp.model.Restaurant;
import pl.strefakursow.eLunchApp.model.User;
import pl.strefakursow.eLunchApp.model.enums.Archive;
import pl.strefakursow.eLunchApp.model.enums.Sex;
import pl.strefakursow.eLunchApp.repo.DelivererRepo;
import pl.strefakursow.eLunchApp.repo.DeliveryAddressRepo;
import pl.strefakursow.eLunchApp.repo.DishRepo;
import pl.strefakursow.eLunchApp.repo.IngredientRepo;
import pl.strefakursow.eLunchApp.repo.MenuItemRepo;
import pl.strefakursow.eLunchApp.repo.OperationEvidenceRepo;
import pl.strefakursow.eLunchApp.repo.OrderItemRepo;
import pl.strefakursow.eLunchApp.repo.ProductRepo;
import pl.strefakursow.eLunchApp.repo.RestaurantRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.service.DelivererService;
import pl.strefakursow.eLunchApp.service.OperationEvidenceService;
import pl.strefakursow.eLunchApp.service.OperationEvidenceServiceImpl;
import pl.strefakursow.eLunchApp.service.OrderItemService;
import pl.strefakursow.eLunchApp.service.OrderItemServiceImpl;
import pl.strefakursow.eLunchApp.service.OrderService;
import pl.strefakursow.eLunchApp.utils.TestUtils;

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

    @Autowired
    private OperationEvidenceRepo operationEvidenceRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private DelivererRepo delivererRepo;

    @Autowired
    private DeliveryAddressRepo deliveryAddressRepo;

    @Autowired
    private IngredientRepo ingredientRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private DishRepo dishRepo;

    @Autowired
    private MenuItemRepo menuItemRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderController orderController;

    @Autowired
    private PlatformTransactionManager txManager;

    private static final String STR_UUID = "33f297cf-5e1e-4385-84c0-b77284fd1ee4";

    @Test
    @Transactional
    public void put1() {
        Restaurant restaurant = TestUtils.restaurant("e19bd597-3466-4aba-afc0-82b333cf10e9", "MakJson",
                TestUtils.logginData("mcJson123", "bigDag123!"),
                TestUtils.companyData("MakJson sp.ooo.",
                        TestUtils.address("St.Patric", "152", "00-000", "NY"),
                        "123-010-00-11", "123123123", "+48 501 502 503", "MJ@gmail.com"),
                Archive.CURRENT);
        restaurantRepo.save(restaurant);

        Deliverer deliverer = TestUtils.deliverer("1ec445f3-e62d-40ab-aa9e-adb2451d403c",
                TestUtils.personalData("John", "Smith", Sex.MALE, "501-501-501", "jh512@gmail.com"),
                TestUtils.logginData("jSmith", "I@mIronM@N12"), Archive.CURRENT);
        delivererRepo.save(deliverer);

        User user = TestUtils.user("99d61a4a-9554-4a84-8dd1-9814113b80a8",
                TestUtils.personalData("John", "Smith", Sex.MALE, "501-501-501", "jh512@gmail.com"),
                null,
                TestUtils.logginData("jSmith", "I@mIronM@N12"),
                Archive.CURRENT);

        DeliveryAddress deliveryAddress = TestUtils.deliveryAddress("57be9bea-1407-4d70-a883-d37d79c36abe", null, "Jana Pawła",
                "1", "1A", "00-000", "Warsaw", null, "Poland", null, user);
        deliveryAddressRepo.save(deliveryAddress);

        TestUtils.ingredient()
    }
}
