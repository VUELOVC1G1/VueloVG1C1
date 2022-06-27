package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Promocion;
import com.complexivo3.vuelovg1c1.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPromocionRepository extends JpaRepository<Promocion, Long>{
    List<Promocion> findAllByVuelo(Vuelo vuelo);
}
