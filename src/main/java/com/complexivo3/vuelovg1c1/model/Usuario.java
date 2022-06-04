package com.complexivo3.vuelovg1c1.model;

import javax.persistence.*;

import com.complexivo3.vuelovg1c1.model.Empleado;
import com.complexivo3.vuelovg1c1.model.Pasajero;
import com.complexivo3.vuelovg1c1.model.UsuarioCharter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
     private String rol; // pasajero, charter, empleado.}

    @Temporal(TemporalType.TIME)
    private Date date;

}
