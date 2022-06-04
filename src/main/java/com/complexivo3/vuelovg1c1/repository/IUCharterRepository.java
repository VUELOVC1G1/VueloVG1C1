package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.UsuarioCharter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUCharterRepository extends JpaRepository<UsuarioCharter, Long> {
}
