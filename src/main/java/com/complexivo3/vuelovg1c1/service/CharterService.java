package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.CharterRequest;
import com.complexivo3.vuelovg1c1.dto.UCharterResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.UCharterMapper;
import com.complexivo3.vuelovg1c1.model.Usuario;
import com.complexivo3.vuelovg1c1.model.UsuarioCharter;
import com.complexivo3.vuelovg1c1.repository.IUCharterRepository;
import com.complexivo3.vuelovg1c1.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CharterService implements ICharterService {

    private final IUCharterRepository charterRepository;
    private final IUsuarioRepository usuarioRepository;


    @Transactional(readOnly = true)
    @Override
    public UCharterResponse findByUsuarioId(Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un usuario con id: " + id));
        UsuarioCharter e = charterRepository.findByUsuario(u)
                .orElseThrow(() -> new NotFoundException("No existe un Charter con usuario id: " + id));

        return UCharterMapper.toResponse(e);
    }

    @Override
    public UCharterResponse editUsuarioCharter(CharterRequest charterRequest, Long idUCharter) {
        UsuarioCharter usuarioCharter = charterRepository.findById(idUCharter)
        .orElseThrow(() -> new NotFoundException("No existe un Charter con id: " + idUCharter));
        if(charterRepository.existsById(idUCharter)){
            Long idUsuario = usuarioCharter.getUsuario().getId();
            usuarioCharter = UCharterMapper.toUCharter(charterRequest);
            usuarioCharter.setId(idUCharter);
            usuarioCharter.getUsuario().setId(idUsuario);
            charterRepository.save(usuarioCharter);
        }
        return UCharterMapper.toResponse(usuarioCharter);
    }

    @Override
    public UCharterResponse deleteUsuarioCharter(Long idUCharter) {
        UsuarioCharter usuarioCharter = charterRepository.findById(idUCharter)
            .orElseThrow(() -> new NotFoundException("No existe un Charter id: " + idUCharter));
        if(charterRepository.existsById(idUCharter)){
            charterRepository.deleteById(idUCharter);
        }
        return UCharterMapper.toResponse(usuarioCharter); 
    }

    @Override
    public List<UCharterResponse> getAllusuariosCharter() {
        List<UCharterResponse> uchartersResponse = new ArrayList<>();
        List<UsuarioCharter> usuariosCharter = charterRepository.findAll();
        for (UsuarioCharter usuarioCharter : usuariosCharter) {
            uchartersResponse.add(UCharterMapper.toResponse(usuarioCharter));
        }
        return uchartersResponse;
    }

}
