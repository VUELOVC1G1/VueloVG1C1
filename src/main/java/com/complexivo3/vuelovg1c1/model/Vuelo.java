package com.complexivo3.vuelovg1c1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    private Double precio;

    private String observacion;

    private boolean estado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vuelo")
    private Date fechaVuelo;

    @OneToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;

    @OneToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoVuelo tipo;

    @OneToMany(mappedBy = "vuelo")
    private List<Promocion> promociones;

}
