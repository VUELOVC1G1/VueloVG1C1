package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.ContactoRequest;
import com.complexivo3.vuelovg1c1.service.ContactoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/contactanos")
public class ContactoController {

    private final ContactoService contactoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ContactoRequest request) {
        contactoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(contactoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        contactoService.deleteById(id);
        return ResponseEntity.ok(id);
    }

}
