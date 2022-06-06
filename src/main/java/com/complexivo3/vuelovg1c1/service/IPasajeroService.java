package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.PasajeroResponse;

public interface IPasajeroService {
    PasajeroResponse findByUsuarioId(Long id);
}
