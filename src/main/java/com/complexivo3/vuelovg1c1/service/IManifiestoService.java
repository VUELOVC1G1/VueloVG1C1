package com.complexivo3.vuelovg1c1.service;

import java.util.List;

import com.complexivo3.vuelovg1c1.dto.ManifiestoRequest;
import com.complexivo3.vuelovg1c1.dto.ManifiestoResponse;

public interface IManifiestoService {
    List<ManifiestoResponse> getAllManifiestos();
    List<ManifiestoResponse> getManifiestosPorCharter(Long idCharter);
    ManifiestoResponse getManifiestoPorId(Long idManifiesto);
    ManifiestoResponse crearManifiesto(ManifiestoRequest manifiestoRequest, Long idCharter);
    ManifiestoResponse modificarManifiesto(ManifiestoRequest manifiestoRequest, Long idManifiesto, Long idCharter);
    ManifiestoResponse eliminarManifiesto(Long idManifiesto);
}
