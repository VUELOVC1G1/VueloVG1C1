package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.HorarioRequest;
import com.complexivo3.vuelovg1c1.dto.HorarioResponse;
import com.complexivo3.vuelovg1c1.dto.RutaRequest;
import com.complexivo3.vuelovg1c1.dto.RutaResponse;
import com.complexivo3.vuelovg1c1.service.IHorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class HorarioController {

    private final IHorarioService iHorarioService;

    @PostMapping("/horarios")
    public ResponseEntity<?> createhorario(@RequestBody HorarioRequest horarioRequest) {
        return new ResponseEntity<>(iHorarioService.guardarhorario(horarioRequest), HttpStatus.CREATED);
    }

    @GetMapping("/horarios/{id}")
    public ResponseEntity<HorarioResponse> findByIdHorario(@PathVariable Long id) {
        return ResponseEntity.ok(iHorarioService.findByHorarioId(id));
    }

    @DeleteMapping("/horarios/{id}")
    public ResponseEntity<?> deletehorariobyId(@PathVariable Long id){

        return new ResponseEntity(iHorarioService.deltevyIdhorario(id),HttpStatus.OK);

    }
    @PutMapping("/horarios")
    public ResponseEntity<?> updateHorario(@RequestBody HorarioRequest horarioRequest) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(iHorarioService.findAll(), HttpStatus.OK);
    }

}
