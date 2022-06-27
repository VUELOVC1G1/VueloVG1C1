package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.CharterRequest;
import com.complexivo3.vuelovg1c1.dto.UCharterResponse;

import java.util.List;


public interface ICharterService {
    List<UCharterResponse> getAllusuariosCharter();
    UCharterResponse findByUsuarioId(Long id);
    UCharterResponse editUsuarioCharter(CharterRequest charterRequest, Long idUCharter);
    UCharterResponse deleteUsuarioCharter(Long idUCharter);
}
