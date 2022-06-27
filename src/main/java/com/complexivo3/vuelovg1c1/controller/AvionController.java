package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.AvionDto;
import com.complexivo3.vuelovg1c1.dto.AvionDtoAsientos;
import com.complexivo3.vuelovg1c1.dto.AvionRequest;
import com.complexivo3.vuelovg1c1.service.AvionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/aviones")
public class AvionController {

    private final AvionService avionService;

    @GetMapping
    public ResponseEntity<List<AvionDto>> getAll() {
        return ResponseEntity.ok(avionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvionDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(avionService.findById(id));
    }


    @GetMapping("{id}/asientos/disponible")
    public ResponseEntity<AvionDtoAsientos> getByIdAsientos(@PathVariable Long id) {
        return ResponseEntity.ok(avionService.findByIdAsientosDisponibles(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AvionDto request) {
        avionService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody AvionDto request) {
        avionService.update(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delteById(@PathVariable Long id) {
        avionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /** ---------------------------------------- MÉTODOS PROPUESTOS PARA ESTE SERVICIO ----------------------------------------
     * @author Eduardo Mendieta
     */
    //@PostMapping("/")
    public ResponseEntity<?> crearAvion(@RequestBody AvionRequest request) {
        return new ResponseEntity<>(avionService.crearAvion(request), HttpStatus.CREATED);
    }
}