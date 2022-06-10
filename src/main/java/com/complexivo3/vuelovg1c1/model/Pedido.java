package com.complexivo3.vuelovg1c1.model;

import java.util.Date;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean estado;
    private String ruta;

    @Temporal(TemporalType.DATE)
    private Date fecha;


    @OneToOne
    @JoinColumn(name = "id_cliente_charter")
    private UsuarioCharter usuarioCharter;
}
