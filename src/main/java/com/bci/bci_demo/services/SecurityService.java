package com.bci.bci_demo.services;

import com.bci.bci_demo.converters.PhoneConverter;
import com.bci.bci_demo.converters.TokenConverter;
import com.bci.bci_demo.dto.Token;
import com.bci.bci_demo.dto.request.SignUpRqDTO;
import com.bci.bci_demo.dto.response.SignUpRsDTO;
import com.bci.bci_demo.entities.User;
import com.bci.bci_demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class SecurityService {


    final UserRepository userRepository;

    @Autowired
    public SecurityService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SignUpRsDTO signUp(final SignUpRqDTO signUpRqDTO) {

        final User user = User.builder()
                .email(signUpRqDTO.getEmail())
                .password(signUpRqDTO.getPassword())
                .lastLogin(LocalDateTime.now())
                .isActive(Boolean.TRUE).build();

        if (signUpRqDTO.getName().isPresent()) {
            user.setName(signUpRqDTO.getName().get());
        }

        if (signUpRqDTO.getPhones().isPresent()) {
            user.setPhones(signUpRqDTO.getPhones().get()
                    .stream()
                    .map(PhoneConverter::toEntity)
                    .collect(Collectors.toList()));
        }

        final User createdUser = this.userRepository.save(user);

        return SignUpRsDTO.builder()
                .id(createdUser.getId().toString())
                .created(createdUser.getCreatedDate())
                .token(generateJwtToken(createdUser))
                .isActive(createdUser.getIsActive())
                .name(createdUser.getName())
                .lastLogin(createdUser.getLastLogin())
                .build();
    }


    private String generateJwtToken(final User user) {
        final Token token = Token.builder()
                .expirationDate(LocalDateTime.now().plusDays(1))
                .userId(user.getId().toString())
                .email(user.getEmail())
                .build();

        return TokenConverter.ToJwtToken(token);
    }
}
