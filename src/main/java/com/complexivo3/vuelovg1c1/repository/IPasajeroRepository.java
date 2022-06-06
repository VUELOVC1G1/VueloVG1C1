package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Pasajero;
import com.complexivo3.vuelovg1c1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPasajeroRepository extends JpaRepository<Pasajero, Long> {
    Optional<Pasajero> findByUsuario(Usuario u);
}
