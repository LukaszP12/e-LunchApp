package pl.strefakursow.eLunchApp.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.strefakursow.eLunchApp.config.JpaConfiguration;
import pl.strefakursow.eLunchApp.controller.UserController;
import pl.strefakursow.eLunchApp.repo.OperationEvidenceRepo;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.service.OperationEvidenceService;
import pl.strefakursow.eLunchApp.service.OperationEvidenceServiceImpl;
import pl.strefakursow.eLunchApp.service.UserService;
import pl.strefakursow.eLunchApp.service.UserServiceImpl;

@SpringBootTest(classes = {
        JpaConfiguration.class,
        OperationEvidenceListenerTest.class
})
public class OperationEvidenceListenerTest {
    @Configuration
    public static class Config {
        @Bean
        public OperationEvidenceService operationEvidenceService(OperationEvidenceRepo operationEvidenceRepo) {
            return new OperationEvidenceServiceImpl(operationEvidenceRepo);
        }

        @Bean
        public OperationEvidenceListener operationEvidenceListener(OperationEvidenceService operationEvidenceService,
                                                                   UserRepo userRepo) {
            return new OperationEvidenceListener(operationEvidenceService, userRepo);
        }

        @Bean
        public UserService userService(UserRepo userRepo) {
            return new UserServiceImpl(userRepo);
        }

        @Bean
        public UserController userController(UserService userService, ApplicationEventPublisher applicationEventPublisher) {
            return new UserController(userService, applicationEventPublisher);
        }
    }

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OperationEvidenceRepo operationEvidenceRepo;

    @Autowired
    private UserController userController;

    private static final String STR_UUID = "168c9a63-56be-47a9-9dce-e4008f7d5d34";
}
