package pl.strefakursow.eLunchApp.utils;

import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.DTO.DelivererDTOBuilder;
import pl.strefakursow.eLunchApp.DTO.DeliveryAddressDTO;
import pl.strefakursow.eLunchApp.DTO.DeliveryAddressDTOBuilder;
import pl.strefakursow.eLunchApp.DTO.LogginDataDTO;
import pl.strefakursow.eLunchApp.DTO.LogginDataDTOBuilder;
import pl.strefakursow.eLunchApp.DTO.PersonalDataDTO;
import pl.strefakursow.eLunchApp.DTO.PersonalDataDTOBuilder;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.model.enums.Archive;
import pl.strefakursow.eLunchApp.model.enums.Sex;

import java.util.ArrayList;
import java.util.UUID;

public class TestUtils {

    public static DelivererDTO delivererDTO(String uuid, PersonalDataDTO personalDataDTO, LogginDataDTO logginDataDTO, Archive archive) {
        return new DelivererDTOBuilder()
                .withUuid(UUID.fromString(uuid))
                .withPersonalData(personalDataDTO)
                .withLoginData(logginDataDTO)
                .withArchive(archive)
                .withOrdersDtos(new ArrayList<>())
                .build();
    }

    public static PersonalDataDTO personalDataDTO(String name, String surname, Sex sex, String phone, String email) {
        return new PersonalDataDTOBuilder()
                .withName(name)
                .withSurname(surname)
                .withSex(sex)
                .withPhone(phone)
                .withEmail(email)
                .build();
    }

    public static LogginDataDTO logginDataDTO(String login, String password) {
        return new LogginDataDTOBuilder()
                .withLogin(login)
                .withPassword(password)
                .build();
    }

    public static DeliveryAddressDTO deliveryAddressDTO(String uuid, String description, String street, String streetNumber,
                                                        String localNumber, String postcode, String city, String borough,
                                                        String county, String state, UserDTO userDTO) {
        return new DeliveryAddressDTOBuilder()
                .withUuid(uuid)
                .withDescription(description)
                .withStreet(street)
                .withStreetNumber(streetNumber)
                .withLocalNumber(localNumber)
                .withCity(city)
                .withBorough(borough)
                .withCounty(county)
                .withState(state)
                .withUser(userDTO);
    }
}
