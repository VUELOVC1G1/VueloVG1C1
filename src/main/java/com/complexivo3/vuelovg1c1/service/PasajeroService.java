package com.complexivo3.vuelovg1c1.service;

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
}
