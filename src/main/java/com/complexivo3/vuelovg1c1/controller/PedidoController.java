package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.PedidoRequest;
import com.complexivo3.vuelovg1c1.dto.PedidoResponse;
import com.complexivo3.vuelovg1c1.service.IPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PedidoController {

    private final IPedidoService iPedidoService;

    @PostMapping("/pedidos")
    public ResponseEntity<?> createpedido(@RequestBody PedidoRequest pedidoRequest) {
        iPedidoService.guardarPedido(pedidoRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<PedidoResponse> findByIdPedido(@PathVariable Long id) {
        return ResponseEntity.ok(iPedidoService.findByPedidoId(id));
    }

    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<?> deletepedidobyId(@PathVariable Long id){

        return new ResponseEntity(iPedidoService.deltevyIdPedido(id),HttpStatus.OK);

    }
    @PutMapping("/pedidos")
    public ResponseEntity<?> updatepedido(@RequestBody PedidoRequest pedidoRequest) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
