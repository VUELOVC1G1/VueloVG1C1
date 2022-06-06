package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.EmpleadoCargoRequest;
import com.complexivo3.vuelovg1c1.dto.EmpleadoResponse;
import com.complexivo3.vuelovg1c1.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadosController {

    private final IEmpleadoService empleadoService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<EmpleadoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.findByUsuarioId(id));
    }

    @PutMapping("/cargo")
    public ResponseEntity<?> saveCargo(@RequestBody EmpleadoCargoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(empleadoService.updateCargo(request));
    }

}
