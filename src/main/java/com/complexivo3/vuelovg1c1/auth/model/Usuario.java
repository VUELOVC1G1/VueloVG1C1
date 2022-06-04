package com.complexivo3.vuelovg1c1.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.complexivo3.vuelovg1c1.model.Empleado;
import com.complexivo3.vuelovg1c1.model.Pasajero;
import com.complexivo3.vuelovg1c1.model.UsuarioCharter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String correo;
     private String password;
     private String rol; // pasajero, charter, empleado.

     /*@OneToOne(mappedBy = "usuario", orphanRemoval = true)
     private Empleado empleado;

     @OneToOne(mappedBy = "usuario", orphanRemoval = true)
     private UsuarioCharter usuarioCharter;

     @OneToOne(mappedBy = "usuario", orphanRemoval = true)
     private Pasajero pasajero;*/
}
