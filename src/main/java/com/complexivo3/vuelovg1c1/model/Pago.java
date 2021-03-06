package com.complexivo3.vuelovg1c1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor_pago;
    private Boolean estado_pago;
    private String tipo;
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "id_boleto")
    private Boleto boleto;

    @PrePersist
    private void initFecha() {
        fecha = new Date();
    }
}
