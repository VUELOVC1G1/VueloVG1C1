package com.complexivo3.vuelovg1c1.controller;

import com.complexivo3.vuelovg1c1.dto.VuelosDiarios;
import com.complexivo3.vuelovg1c1.model.IVuelosGroupByDay;
import com.complexivo3.vuelovg1c1.service.ReportesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reportes")
public class ReportesController {

    private final ReportesService reportesService;

    @GetMapping("/vuelos/dia/a")
    public ResponseEntity<VuelosDiarios> vuelosDiariosA() {
        return ResponseEntity.ok(reportesService.getVuelosDiariosA());
    }

    @GetMapping("/vuelos/dia/b")
    public ResponseEntity<Map<Date, Integer>> vuelosDiariosB() {
        return ResponseEntity.ok(reportesService.getVuelosDiariosB());
    }

    @GetMapping("/vuelos/dia/c")
    public ResponseEntity<List<IVuelosGroupByDay>> vuelosDiariosC() {
        return ResponseEntity.ok(reportesService.getVuelosDiariosC());
    }

    @GetMapping("/facturas")
    public ResponseEntity<?> facturasPorMes() {
        return ResponseEntity.ok(reportesService.getFacturasMensuales());
    }
}
