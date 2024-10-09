package com.sofi.practica_crud_rapido.DTOs;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(min= 1, max = 50, message = "El máximo de caracteres es 50")
    private String nombre;

    @Size(min= 1, max = 50, message = "El máximo de caracteres es 50")
    private String apellido;

    @Pattern(regexp = "\\d{8}", message = " El dni debe tener 8 dígitos, sin puntos")
    private String dni;

}
