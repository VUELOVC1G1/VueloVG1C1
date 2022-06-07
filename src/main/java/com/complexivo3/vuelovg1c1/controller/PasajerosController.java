package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.PasajeroRequest;
import com.complexivo3.vuelovg1c1.dto.PasajeroResponse;
import com.complexivo3.vuelovg1c1.service.IPasajeroService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/pasajeros")
public class PasajerosController {

    private final IPasajeroService pasajeroService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<PasajeroResponse> findByUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(pasajeroService.findByUsuarioId(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PasajeroResponse>> getAllPasajeros(){
        return ResponseEntity.ok(pasajeroService.getAllPasajeros());
    }


    @PutMapping("/{idPasajero}")
    public ResponseEntity<PasajeroResponse> editPasajero(@RequestBody PasajeroRequest pasajeroRequest, @PathVariable Long idPasajero){
        return ResponseEntity.ok(pasajeroService.editPasajero(pasajeroRequest, idPasajero));
    }


    @DeleteMapping("/{idPasajero}")
    public ResponseEntity<PasajeroResponse> deletePasajero(@PathVariable Long idPasajero){
        return ResponseEntity.ok(pasajeroService.deletePasajero(idPasajero));
    }
}
