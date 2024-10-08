package com.sofi.practica_crud_rapido.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlumnoDTO {


    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

}
