package com.complexivo3.vuelovg1c1.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionResponse {
    private String message;
    private HttpStatus error;
    private int status;
}
