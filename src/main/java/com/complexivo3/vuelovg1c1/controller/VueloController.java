package com.complexivo3.vuelovg1c1.controller;


import com.complexivo3.vuelovg1c1.dto.*;
import com.complexivo3.vuelovg1c1.service.IVueloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class VueloController {

    private final IVueloService iVueloService;

    @PostMapping("/vuelos")
    public ResponseEntity<?> createvuelo(@RequestBody VueloRequest vueloRequest) {
        iVueloService.guardarVuelo(vueloRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/vuelos/{id}")
    public ResponseEntity<VueloResponse> findByIdVuelo(@PathVariable Long id) {
        return ResponseEntity.ok(iVueloService.findByVueloId(id));
    }

    @DeleteMapping("/vuelos/{id}")
    public ResponseEntity<?> deletevuelobyId(@PathVariable Long id){

        return new ResponseEntity(iVueloService.deltevyIdVuelo(id),HttpStatus.OK);

    }
    @PutMapping("/vuelos")
    public ResponseEntity<?> updatevuelo(@RequestBody VueloRequest vueloRequest) {
        return new ResponseEntity("Modificado correctamente"+iVueloService.updateVuelo(vueloRequest),HttpStatus.CREATED);
    }
}
