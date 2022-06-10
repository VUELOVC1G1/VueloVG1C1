package com.complexivo3.vuelovg1c1.service;

import java.util.List;

import com.complexivo3.vuelovg1c1.dto.VueloRequest;
import com.complexivo3.vuelovg1c1.dto.VueloResponse;

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
}
