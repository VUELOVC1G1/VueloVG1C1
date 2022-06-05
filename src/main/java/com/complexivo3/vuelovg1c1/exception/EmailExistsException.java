package com.complexivo3.vuelovg1c1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String correo) {
        super("Ya existe una cuenta con este correo: " + correo);
    }
}
