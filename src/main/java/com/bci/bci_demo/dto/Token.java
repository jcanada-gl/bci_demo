package com.bci.bci_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    private String userId;
    private List<String> permissions;
    private LocalDateTime expirationDate;
    private String email;
}
