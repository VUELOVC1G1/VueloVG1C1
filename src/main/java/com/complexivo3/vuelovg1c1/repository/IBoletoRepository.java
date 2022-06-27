package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.dto.IFacturaMes;
import com.complexivo3.vuelovg1c1.model.Boleto;
import com.complexivo3.vuelovg1c1.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IBoletoRepository extends JpaRepository<Boleto, Long> {
    List<Boleto> findAllByPasajero(Pasajero pasajero);

    @Query(value = "SELECT substring (concat(p.fecha, '') , 0, 8) AS mes, SUM(p.valor_pago) AS total " +
            "FROM Pago as p " +
            "GROUP BY 1")
    List<IFacturaMes> findAllGroupByMonth();

    List<Boleto> findAllByPasajeroAndFechaLessThanEqual(Pasajero pasajero, Date fecha);
}
