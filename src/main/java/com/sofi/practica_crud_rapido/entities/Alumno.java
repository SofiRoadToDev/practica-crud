package com.sofi.practica_crud_rapido.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "alumnos")
public class Alumno {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8)
    private String dni;

    @Column(length = 50)
    private String apellido;

    @Column(length = 50)
    private String nombre;

    @ManyToOne
    private Curso curso;

}
