package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.EmpleadoResponse;

public interface IEmpleadoService {
    EmpleadoResponse findByUsuarioId(Long id);
}
