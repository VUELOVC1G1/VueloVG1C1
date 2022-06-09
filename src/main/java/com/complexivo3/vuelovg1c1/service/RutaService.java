package com.complexivo3.vuelovg1c1.service;


import com.complexivo3.vuelovg1c1.dto.RutaRequest;
import com.complexivo3.vuelovg1c1.dto.RutaResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.RutaMapper;
import com.complexivo3.vuelovg1c1.model.Ruta;
import com.complexivo3.vuelovg1c1.repository.IRutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RutaService implements IRutaService {
    private final IRutaRepository iRutaRepository;


    @Transactional
    @Override
    public RutaResponse guardarruta(RutaRequest rutaRequest) {
       Ruta ruta=RutaMapper.toRuta(rutaRequest);
        return RutaMapper.toRutaResponse(iRutaRepository.save(ruta));
    }
    @Transactional
    @Override
    public RutaResponse deltevyIdRuta(Long id) {
    Ruta r= iRutaRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("No existe una ruta  con id: " + id));
        iRutaRepository.delete(r);
        return RutaMapper.toRutaResponse(r);

    }
    @Transactional
    @Override
    public Boolean updateruta(RutaRequest rutaRequest) {
        Optional<Ruta> ur=iRutaRepository.findById(rutaRequest.getId());
            if (ur.isPresent()) {
                ur.get().setDestino(rutaRequest.getDestino());
                ur.get().setOrigen(rutaRequest.getOrigen());
                ur.get().setDescripcion(rutaRequest.getDescripcion());

                try {
                    Ruta rut = iRutaRepository.save(ur.get());
                    return true;
                } catch (Exception ex) {
                    throw new  NotFoundException("No existe una ruta  con id: " + rutaRequest.getId());
                }
            }else{
                throw new  NotFoundException("No existe una ruta  con id: " + rutaRequest.getId());
            }

    }

    @Transactional(readOnly = true)
    @Override
    public RutaResponse findByRutaId(Long id) {
        Ruta r =iRutaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe una ruta  con id: " + id));
        return RutaMapper.toRutaResponse(r);
    }



}
