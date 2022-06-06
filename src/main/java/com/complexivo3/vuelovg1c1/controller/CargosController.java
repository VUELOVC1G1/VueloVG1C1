package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.CargoDto;
import com.complexivo3.vuelovg1c1.dto.CargoRequest;
import com.complexivo3.vuelovg1c1.service.ICargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cargos")
public class CargosController {

    private final ICargoService cargoService;

    @PostMapping
    public ResponseEntity<CargoDto> save(@RequestBody CargoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<CargoDto>> getAll() {
        return ResponseEntity.ok(cargoService.findAll());
    }
}
