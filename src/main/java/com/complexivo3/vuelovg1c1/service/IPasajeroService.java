package com.complexivo3.vuelovg1c1.service;

import java.util.List;

import com.complexivo3.vuelovg1c1.dto.PasajeroRequest;
import com.complexivo3.vuelovg1c1.dto.PasajeroResponse;

public interface IPasajeroService {
    PasajeroResponse findByUsuarioId(Long id);
    List<PasajeroResponse> getAllPasajeros();
    PasajeroResponse editPasajero(PasajeroRequest pasajeroRequest, Long idPasajero);
    PasajeroResponse deletePasajero(Long idPasajero);
}
