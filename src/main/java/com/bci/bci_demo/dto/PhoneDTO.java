package com.bci.bci_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhoneDTO {
    private long number;
    private int cityCode;
    private String countryCode;
}
