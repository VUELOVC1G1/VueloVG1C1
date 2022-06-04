package com.complexivo3.vuelovg1c1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "asientos")
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "id_tipo_asiento")
    private TipoAsiento tipoAsiento;

    @ManyToOne
    @JoinColumn(name = "id_avion")
    private Avion avion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "boleto_asiento",
            joinColumns = @JoinColumn(name = "id_boleto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento", referencedColumnName = "id")
    )
    private List<Boleto> boletos;
}
