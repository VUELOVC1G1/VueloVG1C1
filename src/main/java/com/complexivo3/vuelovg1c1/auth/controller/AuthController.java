package com.complexivo3.vuelovg1c1.auth.controller;


import com.complexivo3.vuelovg1c1.auth.dto.LoginRequest;
import com.complexivo3.vuelovg1c1.auth.dto.UserResponse;
import com.complexivo3.vuelovg1c1.auth.service.AuthService;
import com.complexivo3.vuelovg1c1.model.Pasajero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> doLogin(@RequestBody LoginRequest request) {
        UserResponse response = service.doLogin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Pasajero pasajero) {
        return new ResponseEntity<>(service.signup(pasajero), HttpStatus.CREATED);
    }

}
