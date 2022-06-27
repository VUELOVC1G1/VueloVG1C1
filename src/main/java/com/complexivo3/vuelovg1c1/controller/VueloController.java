package com.complexivo3.vuelovg1c1.controller;


import com.complexivo3.vuelovg1c1.dto.*;
import com.complexivo3.vuelovg1c1.service.IVueloService;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vuelos")
public class VueloController {

    private final IVueloService iVueloService;

    @PostMapping("/")
    public ResponseEntity<?> createvuelo(@RequestBody VueloRequest vueloRequest) {
        iVueloService.guardarVuelo(vueloRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloResponse> findByIdVuelo(@PathVariable Long id) {
        return ResponseEntity.ok(iVueloService.findByVueloId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletetipovuelobyId(@PathVariable Long id){
        return new ResponseEntity<>(iVueloService.deltevyIdVuelo(id),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> updatevuelo(@RequestBody VueloRequest vueloRequest) {
        iVueloService.updateVuelo(vueloRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{vueloId}/asientos/{asientoId}/estado")
    public ResponseEntity<?> asientoDisponible(@PathVariable Long vueloId, @PathVariable Long asientoId) {
        return ResponseEntity.ok(iVueloService.asientoDisponible(vueloId, asientoId));
    }

    @GetMapping("/pasajero/{id}")
    public ResponseEntity<?> vuelosDiario(@PathVariable Long id) {
        return ResponseEntity.ok(iVueloService.vuelosHoyPasajero(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(iVueloService.findAll());
    }


    @GetMapping("/disponibles/rutas/{idRuta}")
    public ResponseEntity<?> getVuelosDisponiblesPorRuta(@PathVariable Long idRuta){
        return ResponseEntity.ok(iVueloService.getVuelosDisponiblesPorRuta(idRuta));
    }


    @GetMapping("/disponibles/{idVuelo}")
    public ResponseEntity<?> getVueloDisponiblePorId(@PathVariable Long idVuelo) {
        return ResponseEntity.ok(iVueloService.getVueloDisponiblePorId(idVuelo));
    }


    @GetMapping("/disponibles/fecha/{idRuta}/{fecha}")
    public ResponseEntity<?> getVuelosDisponiblesPorFechaRuta(@PathVariable Long idRuta, @PathVariable String fecha) {
        return ResponseEntity.ok(iVueloService.getVuelosDisponiblesPorFechaRuta(idRuta, fecha));
    }


    @GetMapping("/disponibles/fecha/{fecha}")
    public ResponseEntity<?> getVuelosDisponiblesPorFecha(@PathVariable String fecha) {
        return ResponseEntity.ok(iVueloService.getVuelosDisponiblesPorFecha(fecha));
    }


    @GetMapping("/disponibles")
    public ResponseEntity<?> getVuelosDisponibles() {
        return ResponseEntity.ok(iVueloService.getVuelosDisponibles());
    }

    @GetMapping("/disponibles/promocion/{idPromocion}")
    public ResponseEntity<?> getVuelosDisponiblesPromocion(@PathVariable Long idPromocion) {
        return ResponseEntity.ok(iVueloService.getVuelosDisponiblesPromocion(idPromocion));
    }

    @GetMapping("/disponibles/promocion/{idPromocion}/{idRuta}")
    public ResponseEntity<?> getVuelosDisponiblesPromocionRuta(@PathVariable Long idPromocion, @PathVariable Long idRuta) {
        return ResponseEntity.ok(iVueloService.getVuelosDisponiblesPromocionRuta(idPromocion, idRuta));
    }
}
