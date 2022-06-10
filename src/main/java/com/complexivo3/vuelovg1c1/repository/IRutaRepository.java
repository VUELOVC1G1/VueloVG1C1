package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRutaRepository extends JpaRepository<Ruta,Long> {
    //para buscar por mas atributos
    //Optional<Ruta> listAll(String destino);
}
