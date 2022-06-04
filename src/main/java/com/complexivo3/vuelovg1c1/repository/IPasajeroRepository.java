package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPasajeroRepository extends JpaRepository<Pasajero, Long> {
}
