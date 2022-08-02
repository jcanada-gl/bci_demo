package com.bci.bci_demo.dto.request;

import com.bci.bci_demo.dto.PhoneDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class SignUpRqDTO {

    private Optional<String> name;
    @Email(message = "El formato del email es incorrecto")
    private String email;
    //@Pattern(regexp = "", message = "El formato del password es incorrecto")
    private String password;
    private Optional<List<PhoneDTO>> phones;


    @Override
    public String toString() {
        return "SignUpRqDTO{" +
                "name=" + name +
                ", email='" + email + '\'' +
                ", phones=" + phones +
                '}';
    }
}
