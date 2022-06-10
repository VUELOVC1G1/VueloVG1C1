package com.complexivo3.vuelovg1c1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complexivo3.vuelovg1c1.dto.ManifiestoRequest;
import com.complexivo3.vuelovg1c1.service.IManifiestoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/manifiestos")
public class ManifiestoController {
    
    private final IManifiestoService manifiestoService;



    @GetMapping("/all")
    public ResponseEntity<?> getAllManifiestos() {
        return ResponseEntity.ok(manifiestoService.getAllManifiestos());
    }

    @GetMapping("/charter/{idCharter}")
    public ResponseEntity<?> getManifiestosPorCharter(@PathVariable Long idCharter) {
        return ResponseEntity.ok(manifiestoService.getManifiestosPorCharter(idCharter));
    }

    @GetMapping("/{idManifiesto}")
    public ResponseEntity<?> getManifiestoPorId(@PathVariable Long idManifiesto) {
        return ResponseEntity.ok(manifiestoService.getManifiestoPorId(idManifiesto));
    }

    @PostMapping("/{idCharter}")
    public ResponseEntity<?> crearManifiesto(@RequestBody ManifiestoRequest manifiestoRequest, @PathVariable Long idCharter) {
        return new ResponseEntity<>(manifiestoService.crearManifiesto(manifiestoRequest, idCharter), HttpStatus.CREATED);
    }

    @PutMapping("/{idManifiesto}/{idCharter}")
    public ResponseEntity<?> modificarManifiesto(@RequestBody ManifiestoRequest manifiestoRequest, @PathVariable Long idManifiesto,
            @PathVariable Long idCharter) {
        return new ResponseEntity<>(manifiestoService.modificarManifiesto(manifiestoRequest, idManifiesto, idCharter), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idManifiesto}")
    public ResponseEntity<?> eliminarManifiesto(@PathVariable Long idManifiesto) {
        return ResponseEntity.ok(manifiestoService.eliminarManifiesto(idManifiesto));
    }
}
