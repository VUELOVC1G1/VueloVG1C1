package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.VueloHoy;
import com.complexivo3.vuelovg1c1.dto.VueloRequest;
import com.complexivo3.vuelovg1c1.dto.VueloResponse;

import java.util.List;

public interface IVueloService {
    VueloResponse findByVueloId(Long id);
    void guardarVuelo(VueloRequest vueloRequest);
    VueloResponse deltevyIdVuelo(Long id);
    Boolean updateVuelo(VueloRequest vueloRequest);

    VueloResponse getVueloDisponiblePorId(Long idVuelo);
    List<VueloResponse> getVuelosDisponiblesPorRuta(Long idRuta);
    List<VueloResponse> getVuelosDisponiblesPorFechaRuta(Long idRuta, String fecha);
    List<VueloResponse> getVuelosDisponiblesPorFecha(String fecha);
    List<VueloResponse> getVuelosDisponibles();
    List<VueloResponse> getVuelosDisponiblesPromocion(Long idPromocion);
    List<VueloResponse> getVuelosDisponiblesPromocionRuta(Long idPromocion, Long idRuta);

    List<VueloResponse> findAll();

    boolean asientoDisponible(Long vueloId, Long asientoId);
    List<VueloHoy> vuelosHoyPasajero(Long id);
}
