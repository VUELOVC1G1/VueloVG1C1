package com.complexivo3.vuelovg1c1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rutas")
public class Ruta {

    @Id
    private Long id;

    private String descripcion;

    private String origen;

    private String destino;

    @OneToOne(mappedBy = "ruta")
    private Vuelo vuelo;
}
