package com.complexivo3.vuelovg1c1.auth.repository;

import com.complexivo3.vuelovg1c1.auth.model.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

}
