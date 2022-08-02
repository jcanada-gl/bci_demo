package com.bci.bci_demo.converters;

import com.bci.bci_demo.dto.PhoneDTO;
import com.bci.bci_demo.entities.Phone;


public final class PhoneConverter {

    public static PhoneDTO toDTO (final Phone phone) {
        return new PhoneDTO(phone.getNumber(), phone.getCityCode(), phone.getCountryCode());
    }

    public static Phone toEntity (final PhoneDTO phoneDTO) {
        return Phone.builder()
                .number(phoneDTO.getNumber())
                .cityCode(phoneDTO.getCityCode())
                .countryCode(phoneDTO.getCountryCode())
                .build();
    }
}
