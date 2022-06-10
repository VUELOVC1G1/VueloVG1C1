package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromocionRepository extends JpaRepository<Promocion,Long> {
}
