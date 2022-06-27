package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Manifiesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IManifiestoRepository extends JpaRepository<Manifiesto, Long>{
    
    @Query(value = "Select * from manifiestos where manifiestos.id_usuario_charter = :idCharter", nativeQuery = true)
    List<Manifiesto> getManifiestosPorCharter(Long idCharter);
}
