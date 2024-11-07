package pl.strefakursow.eLunchApp.DTO;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyTest {

    @Test
    public void test1() {
        // given
        TestAddressDTO testAddressDTO = new TestAddressDTO();
        testAddressDTO.setCity("Warszawa");
        testAddressDTO.setStreet("Jana Pawła");
        testAddressDTO.setStreetNumber("25");
        // when
        TestAddressDTO buildTestAddressDTO = new TestAddressDTO.Builder()
                .setCity("Warszawa")
                .setStreet("Jana Pawła")
                .setStreetNumber("25")
                .build();

        // then
        Assertions.assertEquals(testAddressDTO, buildTestAddressDTO);
    }

}
