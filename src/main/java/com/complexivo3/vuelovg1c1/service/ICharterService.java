package com.complexivo3.vuelovg1c1.service;

import java.util.List;

import com.complexivo3.vuelovg1c1.dto.CharterRequest;
import com.complexivo3.vuelovg1c1.dto.UCharterResponse;


public interface ICharterService {
    List<UCharterResponse> getAllusuariosCharter();
    UCharterResponse findByUsuarioId(Long id);
    UCharterResponse editUsuarioCharter(CharterRequest charterRequest, Long idUCharter);
    UCharterResponse deleteUsuarioCharter(Long idUCharter);
}
