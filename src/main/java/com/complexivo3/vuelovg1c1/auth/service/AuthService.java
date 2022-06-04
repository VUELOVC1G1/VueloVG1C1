package com.complexivo3.vuelovg1c1.auth.service;

import com.complexivo3.vuelovg1c1.auth.dto.LoginRequest;
import com.complexivo3.vuelovg1c1.auth.dto.UserResponse;
import com.complexivo3.vuelovg1c1.auth.mapper.UsuarioMapper;
import com.complexivo3.vuelovg1c1.auth.model.Usuario;
import com.complexivo3.vuelovg1c1.auth.repository.IUsuarioRepository;
import com.complexivo3.vuelovg1c1.exception.AccountNotFoundException;
import com.complexivo3.vuelovg1c1.exception.BadRequestException;
import com.complexivo3.vuelovg1c1.model.Pasajero;
import com.complexivo3.vuelovg1c1.repository.IPasajeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;
    private final IPasajeroRepository pasajeroRepository;

    @Transactional
    public UserResponse doLogin(LoginRequest request) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreo(request.getCorreo());

        if (usuarioOptional.isPresent()) {
            if (request.getPassword().equals(usuarioOptional.get().getPassword()))
                return UsuarioMapper.userToResponse(usuarioOptional.get());
            throw new BadRequestException("Contraseña incorrecta para email: " + request.getCorreo());
        }

        throw new AccountNotFoundException("Cuenta no encontrada con email: " + request.getCorreo());
    }

    public Pasajero signup(Pasajero pasajero) {
        // TODO: comprobar email no exista, y add token

        return pasajeroRepository.save(pasajero);
    }

    /**
     * Asiga un token a un suario de acuerdo al email
     * username=email
     * password=password
     *
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByCorreo(email);
        if (usuario.isPresent()) {
            return new User(usuario.get().getCorreo(), usuario.get().getPassword(), new ArrayList<>());
        }
        throw new AccountNotFoundException("Cuenta no encontrada con email: " + email);
    }

}