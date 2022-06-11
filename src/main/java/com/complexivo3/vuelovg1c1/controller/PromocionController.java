package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.PromocionRequest;
import com.complexivo3.vuelovg1c1.dto.PromocionResponse;
import com.complexivo3.vuelovg1c1.service.IPromocionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PromocionController {

    private final IPromocionService iPromocionService;

    @PostMapping("/promociones")
    public ResponseEntity<?> createpromocion(@RequestBody PromocionRequest  promocionRequest) {
        iPromocionService.guardarPromocion(promocionRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/promociones/{id}")
    public ResponseEntity<?> findByIdPromocion(@PathVariable Long id) {
        return ResponseEntity.ok(iPromocionService.findByPromocionId(id));
    }

    @GetMapping("/promociones")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(iPromocionService.findAll());
    }

    @DeleteMapping("/promociones/{id}")
    public ResponseEntity<?> deletepromocionbyId(@PathVariable Long id){

        return new ResponseEntity(iPromocionService.deltevyIdPromocion(id),HttpStatus.OK);

    }
    @PutMapping("/promociones")
    public ResponseEntity<?> updatepromocion(@RequestBody PromocionRequest promocionRequest) {
        iPromocionService.updatePromocion(promocionRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
