package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.EmpleadoRequest;
import com.complexivo3.vuelovg1c1.dto.EmpleadoResponse;

import java.util.List;

public interface IEmpleadoService {
    EmpleadoResponse findByUsuarioId(Long id);
    List<EmpleadoResponse> getAllEmpleados();
    EmpleadoResponse editEmpleado(EmpleadoRequest empleadoRequest, Long idEmpleado);
    EmpleadoResponse deleteEmpleado(Long idEmpleado);
}
