package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.RutaRequest;
import com.complexivo3.vuelovg1c1.dto.RutaResponse;
import com.complexivo3.vuelovg1c1.dto.TipoVueloRequest;
import com.complexivo3.vuelovg1c1.dto.TipoVueloResponse;
import com.complexivo3.vuelovg1c1.repository.ITipoVueloRepository;
import com.complexivo3.vuelovg1c1.service.ITipoVueloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class TipoVueloController {

    private final ITipoVueloService iTipoVueloService;

    @PostMapping("/tiposvuelos")
    public ResponseEntity<?> createtipovuelo(@RequestBody TipoVueloRequest tipoVueloRequest) {
        return new ResponseEntity<>(iTipoVueloService.guardartipovuelo(tipoVueloRequest), HttpStatus.CREATED);
    }

    @GetMapping("/tiposvuelos/{id}")
    public ResponseEntity<TipoVueloResponse> findByIdtipovuelo(@PathVariable Long id) {
        return ResponseEntity.ok(iTipoVueloService.findBytipovueloId(id));
    }

    @DeleteMapping("/tiposvuelos/{id}")
    public ResponseEntity<?> deletetipovuelobyId(@PathVariable Long id){

        return new ResponseEntity(iTipoVueloService.deltevyIdtipovuelo(id),HttpStatus.OK);

    }
    @PutMapping("/tiposvuelos")
    public ResponseEntity<?> updatetipovuelo(@RequestBody TipoVueloRequest tipoVueloRequest) {
        return new ResponseEntity("Modificado correctamente"+iTipoVueloService.updatetipovuelo(tipoVueloRequest),HttpStatus.CREATED);
    }
}
