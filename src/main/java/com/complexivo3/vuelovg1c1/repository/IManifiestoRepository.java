package com.complexivo3.vuelovg1c1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.complexivo3.vuelovg1c1.model.Manifiesto;

@Repository
public interface IManifiestoRepository extends JpaRepository<Manifiesto, Long>{
    
    @Query(value = "Select * from manifiestos where manifiestos.id_usuario_charter = :idCharter", nativeQuery = true)
    List<Manifiesto> getManifiestosPorCharter(Long idCharter);
}
