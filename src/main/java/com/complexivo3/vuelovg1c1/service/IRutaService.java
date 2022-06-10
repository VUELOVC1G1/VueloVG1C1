package com.complexivo3.vuelovg1c1.service;


import com.complexivo3.vuelovg1c1.dto.RutaRequest;
import com.complexivo3.vuelovg1c1.dto.RutaResponse;



public interface IRutaService {
    RutaResponse findByRutaId(Long id);
    RutaResponse guardarruta(RutaRequest rutaRequest);
    RutaResponse deltevyIdRuta(Long id);
    Boolean updateruta(RutaRequest rutaRequest);
}
