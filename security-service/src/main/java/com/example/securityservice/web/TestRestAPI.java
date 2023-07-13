package com.example.securityservice.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestRestAPI {
    @GetMapping("/api/data-test")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Map<String, Object> dataTest(Authentication authentication){
        return Map.of(
                "message", "Hello World",
                "username", authentication.getName(),
                "authorities", authentication.getAuthorities()
        );
    }
    @PostMapping("/api/save-data")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Map<String, String> saveData(String data){
        return Map.of(
                "dataSaved", data);
    }
}
