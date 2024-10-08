package com.sofi.practica_crud_rapido.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cursos")
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String codigo;
    @Column(length = 50)
    private String nombre;

    @Column(length = 100)
    private String descripcion;

    private Integer duracionHoras;

    @OneToMany( mappedBy = "curso", cascade = CascadeType.MERGE)
    private Set<Alumno> alumnosInscriptos = new HashSet<>();
}
