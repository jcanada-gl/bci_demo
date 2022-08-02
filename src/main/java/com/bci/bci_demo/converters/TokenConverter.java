package com.bci.bci_demo.converters;

import com.bci.bci_demo.dto.Token;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class TokenConverter {
    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());

    public static String ToJwtToken (final Token token) {

        String tokenJsonStr = "";

        try {
            tokenJsonStr = mapper.writeValueAsString(token);
        } catch (JsonProcessingException ex) {
            System.out.println("Error al generar el token");
        }

        final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        return Jwts.builder()
                .setPayload(tokenJsonStr)
                .signWith(key)
                .compact();
    }
}
