package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.PasajeroRequest;
import com.complexivo3.vuelovg1c1.dto.PasajeroResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.PasajeroMapper;
import com.complexivo3.vuelovg1c1.model.Pasajero;
import com.complexivo3.vuelovg1c1.model.Usuario;
import com.complexivo3.vuelovg1c1.repository.IPasajeroRepository;
import com.complexivo3.vuelovg1c1.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PasajeroService implements IPasajeroService {

    private final IPasajeroRepository pasajeroRepository;
    private final IUsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public PasajeroResponse findByUsuarioId(Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un usuario con id: " + id));
        Pasajero p = pasajeroRepository.findByUsuario(u)
                .orElseThrow(() -> new NotFoundException("No existe un pasajero con usuario id: " + id));
        return PasajeroMapper.toResponse(p);
    }

    @Override
    public PasajeroResponse deletePasajero(Long idPasajero) {
        Pasajero pasajero = pasajeroRepository.findById(idPasajero)
            .orElseThrow(() -> new NotFoundException("No existe un Pasajero id: " + idPasajero));
        if(pasajeroRepository.existsById(idPasajero)){
            pasajeroRepository.deleteById(idPasajero);
        }
        return PasajeroMapper.toResponse(pasajero); 
    }

    @Override
    public PasajeroResponse editPasajero(PasajeroRequest pasajeroRequest, Long idPasajero) {
        Pasajero pasajero = pasajeroRepository.findById(idPasajero)
            .orElseThrow(() -> new NotFoundException("No existe un Pasajero con id: " + idPasajero));
        if(pasajeroRepository.existsById(idPasajero)){
            Long idUsuario = pasajero.getUsuario().getId();
            pasajero = PasajeroMapper.toPasajero(pasajeroRequest);
            pasajero.setId(idPasajero);
            pasajero.getUsuario().setId(idUsuario);
            pasajeroRepository.save(pasajero);
        }
        return PasajeroMapper.toResponse(pasajero);
    }

    @Override
    public List<PasajeroResponse> getAllPasajeros() {
        List<PasajeroResponse> pasajerosResponse = new ArrayList<>();
        List<Pasajero> pasajeros = pasajeroRepository.findAll();
        for (Pasajero pasajero : pasajeros) {
            pasajerosResponse.add(PasajeroMapper.toResponse(pasajero));
        }
        return pasajerosResponse;
    }

    
}
