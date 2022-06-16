package com.complexivo3.vuelovg1c1.notifications.service;

import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.model.Usuario;
import com.complexivo3.vuelovg1c1.notifications.dto.UsuarioTokenRequest;
import com.complexivo3.vuelovg1c1.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserTokenService {

    private final IUsuarioRepository usuarioRepository;

    @Transactional
    public void save(UsuarioTokenRequest usuario) {

        Usuario u = usuarioRepository.findById(usuario.getUsuarioId())
                .orElseThrow(() -> new NotFoundException("No existe usuario con id: " + usuario.getUsuarioId()));

        u.setAndroidToken(usuario.getToken());
        usuarioRepository.save(u);
    }


}
