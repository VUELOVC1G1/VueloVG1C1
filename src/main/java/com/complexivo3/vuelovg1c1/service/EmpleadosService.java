package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.EmpleadoResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.EmpleadoMapper;
import com.complexivo3.vuelovg1c1.model.Empleado;
import com.complexivo3.vuelovg1c1.model.Usuario;
import com.complexivo3.vuelovg1c1.repository.IEmpleadoRepository;
import com.complexivo3.vuelovg1c1.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class EmpleadosService implements IEmpleadoService {

    private final IEmpleadoRepository empleadoRepository;
    private final IUsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public EmpleadoResponse findByUsuarioId(Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un usuario con id: " + id));
        Empleado e = empleadoRepository.findByUsuario(u)
                .orElseThrow(() -> new NotFoundException("No existe un empleado con usuario id: " + id));

        return EmpleadoMapper.toResponse(e);
    }

}
