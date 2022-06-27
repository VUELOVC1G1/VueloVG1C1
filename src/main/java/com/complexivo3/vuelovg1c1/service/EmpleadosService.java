package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.EmpleadoRequest;
import com.complexivo3.vuelovg1c1.dto.EmpleadoResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.EmpleadoMapper;
import com.complexivo3.vuelovg1c1.model.Cargo;
import com.complexivo3.vuelovg1c1.model.Empleado;
import com.complexivo3.vuelovg1c1.model.Usuario;
import com.complexivo3.vuelovg1c1.repository.ICargoRepository;
import com.complexivo3.vuelovg1c1.repository.IEmpleadoRepository;
import com.complexivo3.vuelovg1c1.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class EmpleadosService implements IEmpleadoService {

    private final IEmpleadoRepository empleadoRepository;
    private final IUsuarioRepository usuarioRepository;
    private final ICargoRepository cargoRepository;

    @Transactional(readOnly = true)
    @Override
    public EmpleadoResponse findByUsuarioId(Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un usuario con id: " + id));
        Empleado e = empleadoRepository.findByUsuario(u)
                .orElseThrow(() -> new NotFoundException("No existe un empleado con usuario id: " + id));

        return EmpleadoMapper.toResponse(e);
    }

    @Override
    public List<EmpleadoResponse> getAllEmpleados() {
        List<EmpleadoResponse> empleadosResponse = new ArrayList<>();
        List<Empleado> empleados = empleadoRepository.findAll();
        for (Empleado empleado: empleados) {
            empleadosResponse.add(EmpleadoMapper.toResponse(empleado));
        }
        return empleadosResponse;
    }


    @Override
    public EmpleadoResponse editEmpleado(EmpleadoRequest empleadoRequest, Long idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElseThrow(() -> new NotFoundException("No existe un Empleado con id: " + idEmpleado));
        Long idCargo = empleadoRequest.getCargo().getId();
        Cargo cargo = cargoRepository.findById(idCargo).orElseThrow(() -> new NotFoundException("No existe el Cargo con id: " + idCargo));
        if(empleadoRepository.existsById(idEmpleado) && cargoRepository.existsById(idCargo)){
            Long idUsuario = empleado.getUsuario().getId();
            empleado = EmpleadoMapper.toEmpleado(empleadoRequest);
            empleado.setId(idEmpleado);
            empleado.getUsuario().setId(idUsuario);
            empleado.getCargo().setId(cargo.getId());

            empleado = empleadoRepository.save(empleado);
        }
        return EmpleadoMapper.toResponse(empleado);
    }

    
    @Override
    public EmpleadoResponse deleteEmpleado(Long idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado)
            .orElseThrow(() -> new NotFoundException("No existe un Empleado con id: " + idEmpleado));
        if(empleadoRepository.existsById(idEmpleado)){
            empleadoRepository.deleteById(idEmpleado);
        }
        return EmpleadoMapper.toResponse(empleado);
    }

}
