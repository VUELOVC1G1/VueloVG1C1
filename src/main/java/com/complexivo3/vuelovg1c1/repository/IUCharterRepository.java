package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Usuario;
import com.complexivo3.vuelovg1c1.model.UsuarioCharter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUCharterRepository extends JpaRepository<UsuarioCharter, Long> {
    Optional<UsuarioCharter> findByUsuario(Usuario u);
}
