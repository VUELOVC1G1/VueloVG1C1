package com.complexivo3.vuelovg1c1.repository;

import com.complexivo3.vuelovg1c1.dto.IVueloMensual;
import com.complexivo3.vuelovg1c1.model.IVuelosGroupByDay;
import com.complexivo3.vuelovg1c1.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IVueloRepository extends JpaRepository<Vuelo,Long> {

    @Query(value = "Select * from vuelos where vuelos.id_ruta = :idRuta and vuelos.estado = :estado", nativeQuery = true)
    public List<Vuelo> getVuelosDisponiblesPorRuta(Long idRuta, boolean estado);

    @Query(value = "Select * from vuelos where vuelos.id = :idVuelo and vuelos.estado = :estado", nativeQuery = true)
    public Optional<Vuelo> getVueloDisponiblePorId(Long idVuelo, boolean estado);

    @Query(value = "Select * from vuelos where vuelos.id_ruta = :idRuta and vuelos.fecha_vuelo = :fecha and vuelos.estado = :estado", nativeQuery = true)
    public List<Vuelo> getVuelosDisponiblesPorFechaRuta(Long idRuta, Date fecha, boolean estado); 

    @Query(value = "Select * from vuelos where vuelos.fecha_vuelo = :fecha and vuelos.estado = :estado", nativeQuery = true)
    public List<Vuelo>getVuelosDisponiblesPorFecha(Date fecha, boolean estado);

    @Query(value = "Select * from vuelos where vuelos.estado = :estado", nativeQuery = true)
    public List<Vuelo> getVuelosPorEstado(boolean estado);

    @Query(
        value = "Select * from vuelos inner join promociones on vuelos.id = promociones.id_vuelo where promociones.id = :idPromocion and vuelos.estado = :estado",
        nativeQuery = true)
    public List<Vuelo> getVuelosDisponiblesPromocion(Long idPromocion, boolean estado);

    @Query(
        value = "Select * from vuelos inner join promociones on vuelos.id = promociones.id_vuelo where promociones.id = :idPromocion and vuelos.id_ruta = :idRuta and vuelos.estado = :estado", 
        nativeQuery = true)
    public List<Vuelo> getVuelosDisponiblesPromocionRuta(Long idPromocion, Long idRuta, boolean estado);


    @Query(
            value = "SELECT substring (concat(v.fechaVuelo, '') , 0, 11) as fecha, COUNT(v.id) AS numVuelos " +
                    "FROM Vuelo AS v " +
                    "GROUP BY 1"
    )
    List<IVuelosGroupByDay> findAllGroupByFechaVuelo();

    @Query(
            value = "SELECT substring (concat(v.fechaVuelo, '') , 0, 8) AS fecha, COUNT(v.id) AS numVuelos " +
                    "FROM Vuelo AS v " +
                    "GROUP BY 1"
    )
    List<IVueloMensual> findAllGroupByFechaVueloMensual();
    @Query(
            value = "select * from vuelos v where extract(minute from v.fecha_vuelo) - extract(minute from current_time) = 2",
            nativeQuery = true)
    public List<Vuelo> getVuelos();
}
