package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.AvionDto;
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

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AvionDto request) {
        avionService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<AvionDto> update(@RequestBody AvionDto request) {
        return ResponseEntity.ok(avionService.update(request));
    }
}
