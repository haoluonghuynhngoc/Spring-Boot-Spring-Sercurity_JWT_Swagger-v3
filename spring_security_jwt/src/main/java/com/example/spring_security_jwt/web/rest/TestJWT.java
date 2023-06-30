package com.example.spring_security_jwt.web.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestJWT {
    @GetMapping("/")
    @SecurityRequirement(name = "Bearer Authentication")
    public String testDemo(){
        return "this is the test";
    }
}
