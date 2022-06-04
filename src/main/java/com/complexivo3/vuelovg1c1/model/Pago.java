package com.complexivo3.vuelovg1c1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="pagos")
public class Pago {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor_pago ;
    private Boolean estado_pago;
    private String tipo;

    @OneToOne
    @JoinColumn(name = "id_boleto")
    private Boleto boleto;
}
