package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.EmpleadoResponse;
import com.complexivo3.vuelovg1c1.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadosController {

    private final IEmpleadoService empleadoService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<EmpleadoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.findByUsuarioId(id));
    }

}
