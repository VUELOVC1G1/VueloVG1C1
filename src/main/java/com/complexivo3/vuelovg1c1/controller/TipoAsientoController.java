package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.TipoAsientoDto;
import com.complexivo3.vuelovg1c1.service.TipoAsientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tiposasiento")
public class TipoAsientoController {

    private final TipoAsientoService asientoService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(asientoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(asientoService.findById(id));
    }

}
