package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.CharterRequest;
import com.complexivo3.vuelovg1c1.dto.UCharterResponse;
import com.complexivo3.vuelovg1c1.service.ICharterService;

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
@RequestMapping("/api/v1/charters")
public class CharterController {

    private final ICharterService charterService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UCharterResponse> findByUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(charterService.findByUsuarioId(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UCharterResponse>> getAllUsuariosCharter(){
        return ResponseEntity.ok(charterService.getAllusuariosCharter());
    }


    @PutMapping("/usuario/{idUCharter}")
    public ResponseEntity<UCharterResponse> editUsuarioCharter(@RequestBody CharterRequest charterRequest, @PathVariable Long idUCharter){
        return ResponseEntity.ok(charterService.editUsuarioCharter(charterRequest, idUCharter));
    }


    @DeleteMapping("/usuario/{idUCharter}")
    public ResponseEntity<UCharterResponse> deleteUsuarioCharter(@PathVariable Long idUCharter){
        return ResponseEntity.ok(charterService.deleteUsuarioCharter(idUCharter));
    }
}
