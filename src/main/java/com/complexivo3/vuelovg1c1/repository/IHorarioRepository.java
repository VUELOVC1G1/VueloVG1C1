package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioRepository extends JpaRepository<Horario,Long> {
}
