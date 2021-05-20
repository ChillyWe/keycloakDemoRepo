package com.example.productapp.controller;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
import java.util.Map;

@RestController
class ProductController {

    @Autowired
    private KeycloakRestTemplate keycloakRestTemplate;

    @GetMapping(path = "/home")
    public Map<String, String> getProducts(Principal principal) {
        ResponseEntity<String> response = keycloakRestTemplate.getForEntity("http://localhost:8001/api/articles", String.class);
        return Map.of("UserName", principal.getName(),
                "Principal", principal.toString(),
                "Kotlin", response.getBody());
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "You are now logout";
    }

}
