package com.complexivo3.vuelovg1c1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contactanos")
public class Contacto {
    @Id
    @GeneratedValue
    private Long id;
    private String cedula;
    private String correo;
    private String nombres;
    private String apellidos;
    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @PrePersist
    private void createdAtDate() {
        this.fecha = new Date();
    }

}
