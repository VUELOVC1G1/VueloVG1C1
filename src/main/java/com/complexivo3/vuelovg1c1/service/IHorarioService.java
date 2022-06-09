package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.HorarioRequest;
import com.complexivo3.vuelovg1c1.dto.HorarioResponse;


public interface IHorarioService {
    HorarioResponse findByHorarioId(Long id);
    HorarioResponse guardarhorario(HorarioRequest horarioRequest);
    HorarioResponse deltevyIdhorario(Long id);
    Boolean updateIdhorario(HorarioRequest horarioRequest);
}
