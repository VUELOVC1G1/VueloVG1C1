package com.complexivo3.vuelovg1c1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.complexivo3.vuelovg1c1.model.Promocion;

@Repository
public interface IPromocionRepository extends JpaRepository<Promocion, Long>{
    
}
