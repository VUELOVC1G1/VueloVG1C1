package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Asiento;
import com.complexivo3.vuelovg1c1.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAsientoRepository extends JpaRepository<Asiento, Long> {
    List<Asiento> findAllByAvion(Avion avion);
}
