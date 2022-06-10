package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Boleto;
import com.complexivo3.vuelovg1c1.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBoletoRepository extends JpaRepository<Boleto, Long> {
    List<Boleto> findAllByPasajero(Pasajero pasajero);
}
