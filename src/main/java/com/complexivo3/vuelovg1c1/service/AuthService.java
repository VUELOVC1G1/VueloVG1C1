package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.*;
import com.complexivo3.vuelovg1c1.exception.EmailExistsException;
import com.complexivo3.vuelovg1c1.mapper.EmpleadoMapper;
import com.complexivo3.vuelovg1c1.mapper.PasajeroMapper;
import com.complexivo3.vuelovg1c1.mapper.UCharterMapper;
import com.complexivo3.vuelovg1c1.mapper.UsuarioMapper;
import com.complexivo3.vuelovg1c1.model.Empleado;
import com.complexivo3.vuelovg1c1.model.Usuario;
import com.complexivo3.vuelovg1c1.model.UsuarioCharter;
import com.complexivo3.vuelovg1c1.repository.IEmpleadoRepository;
import com.complexivo3.vuelovg1c1.repository.IUCharterRepository;
import com.complexivo3.vuelovg1c1.repository.IUsuarioRepository;
import com.complexivo3.vuelovg1c1.exception.AccountNotFoundException;
import com.complexivo3.vuelovg1c1.exception.BadRequestException;
import com.complexivo3.vuelovg1c1.model.Pasajero;
import com.complexivo3.vuelovg1c1.repository.IPasajeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final IUsuarioRepository usuarioRepository;
    private final IEmpleadoRepository empleadoRepository;
    private final IUCharterRepository charterRepository;
    private final IPasajeroRepository pasajeroRepository;

    @Transactional(readOnly = true)
    @Override
    public UserResponse doLogin(LoginRequest request) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreo(request.getCorreo());

        if (usuarioOptional.isPresent()) {
            if (request.getPassword().equals(usuarioOptional.get().getPassword()))
                return UsuarioMapper.userToResponse(usuarioOptional.get());
            throw new BadRequestException("Contraseña incorrecta para email: " + request.getCorreo());
        }
        throw new AccountNotFoundException(request.getCorreo());
    }

    @Transactional
    @Override
    public PasajeroResponse signupPasajero(PasajeroRequest request) {
        existsEmail(request.getUsuario().getCorreo());
        Pasajero pasajero = PasajeroMapper.toPasajero(request);
        return PasajeroMapper.toResponse(pasajeroRepository.save(pasajero));
    }

    @Transactional
    @Override
    public EmpleadoResponse signupEmpleado(EmpleadoRequest request) {
        existsEmail(request.getUsuario().getCorreo());
        Empleado empleado = EmpleadoMapper.toEmpleado(request);
        return EmpleadoMapper.toResponse(empleadoRepository.save(empleado));
    }

    @Transactional
    @Override
    public UCharterResponse signupCharter(CharterRequest request) {
        existsEmail(request.getUsuario().getCorreo());
        UsuarioCharter charter = UCharterMapper.toUCharter(request);
        return UCharterMapper.toResponse(charterRepository.save(charter));
    }

    private void existsEmail(String email) {
        if (usuarioRepository.existsByCorreo(email)) {
            throw new EmailExistsException(email);
        }
    }

}