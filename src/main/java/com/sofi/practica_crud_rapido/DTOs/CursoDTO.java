package com.sofi.practica_crud_rapido.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private String codigo;

    private int duracionHoras;
}
