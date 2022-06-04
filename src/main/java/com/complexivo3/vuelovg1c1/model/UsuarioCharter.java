package com.complexivo3.vuelovg1c1.model;

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
@Table(name = "usuarios_charter")
public class UsuarioCharter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruc;
    private String empresa;


    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne(mappedBy = "usuarioCharter", orphanRemoval = true)
    private Manifiesto manifiesto;

    @OneToOne(mappedBy = "usuarioCharter", orphanRemoval = true)
    private Pedido pedido;
}
