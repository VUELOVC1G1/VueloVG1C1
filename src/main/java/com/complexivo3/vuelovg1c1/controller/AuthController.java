package com.complexivo3.vuelovg1c1.controller;


import com.complexivo3.vuelovg1c1.dto.*;
import com.complexivo3.vuelovg1c1.service.IAuthService;
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

    private final IAuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> doLogin(@RequestBody LoginRequest request) {
        UserDto response = service.doLogin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signup/pasajero")
    public ResponseEntity<?> signup(@RequestBody PasajeroRequest request) {
        return new ResponseEntity<>(service.signupPasajero(request), HttpStatus.CREATED);
    }

    @PostMapping("/signup/empleado")
    public ResponseEntity<?> signup(@RequestBody EmpleadoRequest request) {
        return new ResponseEntity<>(service.signupEmpleado(request), HttpStatus.CREATED);
    }

    @PostMapping("/signup/charter")
    public ResponseEntity<?> signup(@RequestBody CharterRequest request) {
        return new ResponseEntity<>(service.signupCharter(request), HttpStatus.CREATED);
    }

}
