package com.complexivo3.vuelovg1c1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="boletos")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    private String qr;

    @OneToOne(mappedBy = "boleto", orphanRemoval = true)
    private Pago pagos;

    @OneToMany(mappedBy = "boleto" , orphanRemoval = true)
    private List<Maleta> maletas;
}
