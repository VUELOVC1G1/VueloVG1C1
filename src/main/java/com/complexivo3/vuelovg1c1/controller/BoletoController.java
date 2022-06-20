package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.BoletoDto;
import com.complexivo3.vuelovg1c1.dto.BoletoRequest;
import com.complexivo3.vuelovg1c1.service.BoletoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/boletos")
public class BoletoController {

    private final BoletoService boletoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(boletoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BoletoRequest request) {
        boletoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/pasajero/{id}")
    public ResponseEntity<?> findByPasajero(@PathVariable Long id) {
        return ResponseEntity.ok(boletoService.findByPasajeroId(id));
    }

    @GetMapping
    public ResponseEntity<List<BoletoDto>> getAll() {
        return ResponseEntity.ok(boletoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        boletoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
