package com.complexivo3.vuelovg1c1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {AccountNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleAccountNotFoundException(AccountNotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        response.setStatus(404);
        response.setError(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        response.setStatus(404);
        response.setError(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        response.setStatus(400);
        response.setError(HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = {EmailExistsException.class})
    public ResponseEntity<ExceptionResponse> handleEmailExiststException(EmailExistsException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        response.setStatus(400);
        response.setError(HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(response);
    }
}
