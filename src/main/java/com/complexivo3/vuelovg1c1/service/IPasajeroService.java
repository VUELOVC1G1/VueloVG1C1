package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.PasajeroRequest;
import com.complexivo3.vuelovg1c1.dto.PasajeroResponse;

import java.util.List;

public interface IPasajeroService {
    PasajeroResponse findByUsuarioId(Long id);
    List<PasajeroResponse> getAllPasajeros();
    PasajeroResponse editPasajero(PasajeroRequest pasajeroRequest, Long idPasajero);
    PasajeroResponse deletePasajero(Long idPasajero);
}
