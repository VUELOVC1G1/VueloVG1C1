package com.complexivo3.vuelovg1c1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.complexivo3.vuelovg1c1.auth.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pasajeros")
public class Pasajero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cedula;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    private String nombre;
    private String apellido;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
