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
@Table(name="aviones")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String nombre;
    private Boolean estado;
    private String wifi;
    private String modelo;
    private String marca;

    @OneToMany(mappedBy = "avion",orphanRemoval = true)
    private List<Asiento> asientos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "vuelo_avion",
            joinColumns = @JoinColumn(name = "id_vuelo", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_avion", referencedColumnName = "id")
    )
    private List<Vuelo> vuelos;

}
