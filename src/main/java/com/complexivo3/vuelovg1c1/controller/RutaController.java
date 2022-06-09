package com.complexivo3.vuelovg1c1.controller;


import com.complexivo3.vuelovg1c1.dto.RutaRequest;
import com.complexivo3.vuelovg1c1.dto.RutaResponse;
import com.complexivo3.vuelovg1c1.service.IRutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class RutaController {

    private final IRutaService iRutaService;

    @PostMapping("/rutas")
    public ResponseEntity<?> createruta(@RequestBody RutaRequest rutaRequest) {
        return new ResponseEntity<>(iRutaService.guardarruta(rutaRequest), HttpStatus.CREATED);
    }

    @GetMapping("/rutas/{id}")
    public ResponseEntity<RutaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iRutaService.findByRutaId(id));
    }

    @DeleteMapping("/rutas/{id}")
    public ResponseEntity<?> deleterutabyId(@PathVariable Long id){

        return new ResponseEntity(iRutaService.deltevyIdRuta(id),HttpStatus.OK);

    }
    @PutMapping
    public ResponseEntity<?> updateruta(@RequestBody RutaRequest rutaRequest) {
        return new ResponseEntity("Modificado correctamente"+iRutaService.updateruta(rutaRequest),HttpStatus.CREATED);
    }
}
