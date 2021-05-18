package com.example.productapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;

@RestController
class ProductController {

    @GetMapping(path = "/products")
    public String getProducts(Principal principal){
        return "Hello " + principal.getName() +
                System.lineSeparator() +
                Arrays.asList("iPad", "iPhone", "iPod");
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "You are now logout";
    }
}
