package com.complexivo3.vuelovg1c1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

    public  AccountNotFoundException(String correo) {
        super(String.format("No existe una cuenta con este correo: %s", correo));
    }
}
