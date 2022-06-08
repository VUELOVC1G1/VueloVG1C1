package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.EmpleadoRequest;
import com.complexivo3.vuelovg1c1.dto.EmpleadoResponse;
import com.complexivo3.vuelovg1c1.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<EmpleadoResponse>> getAllUsuariosCharter(){
        return ResponseEntity.ok(empleadoService.getAllEmpleados());
    }


    @PutMapping("/{idEmpleado}")
    public ResponseEntity<EmpleadoResponse> editUsuarioCharter(@RequestBody EmpleadoRequest empleadoRequest, @PathVariable Long idEmpleado){
        return ResponseEntity.ok(empleadoService.editEmpleado(empleadoRequest, idEmpleado));
    }


    @DeleteMapping("/{idEmpleado}")
    public ResponseEntity<EmpleadoResponse> deleteUsuarioCharter(@PathVariable Long idEmpleado){
        return ResponseEntity.ok(empleadoService.deleteEmpleado(idEmpleado));
    }
}
