package com.bci.bci_demo.controllers;

import com.bci.bci_demo.dto.request.SignUpRqDTO;
import com.bci.bci_demo.dto.response.SignUpRsDTO;
import com.bci.bci_demo.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/security")
public class SecurityController {

    private final SecurityService securityService;

    @Autowired
    public SecurityController(final SecurityService securityService) {
        this.securityService = securityService;
    }


    @PostMapping(path = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignUpRsDTO> signUp(@RequestBody final SignUpRqDTO signUpRqDTO) {
        final SignUpRsDTO response = this.securityService.signUp(signUpRqDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
