package pl.strefakursow.eLunchApp.utils;

import pl.strefakursow.eLunchApp.DTO.DelivererDTO;
import pl.strefakursow.eLunchApp.model.Deliverer;

public class ConverterUtils {

    public static DelivererDTO convert(Deliverer deliverer) {
        DelivererDTO delivererDTO = new DelivererDTO();
        delivererDTO.setUuid(deliverer.getUuid());
        ////

        return null;
    }

}
